package com.siwanper.gateway.web.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siwanper.gateway.web.service.IPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class AccessGatewayFilter implements GlobalFilter {


    private static final String X_CLIENT_TOKEN_USER = "x_client_token_user";

    private static final String X_CLIENT_TOKEN = "x_client_token";

    @Autowired
    private IPermissionService permissionService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String authentication = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        String url = request.getPath().value();
        String method = request.getMethodValue();
        log.debug("url:{}, method:{}, authentication:{}", url, method, authentication);

        // 判断请求的url是否需要签权
        if (permissionService.ignoreAuthentication(url)) {
            return chain.filter(exchange);
        }

        // 判断用户是否有访问权限
        if (permissionService.hasPermission(authentication, url, method)) {
            ServerHttpRequest.Builder builder = request.mutate();
            builder.header(X_CLIENT_TOKEN, "服务间认证");
            builder.header(X_CLIENT_TOKEN_USER, getUserToken(authentication));
            return chain.filter(exchange.mutate().request(builder.build()).build());
        }

        return unauthorized(exchange);
    }

    private String getUserToken(String authentication){
        String token = "{}";
        try {
            token = new ObjectMapper().writeValueAsString(permissionService.getJwtToken(authentication).getBody());
            log.info("token : {}", token);
        } catch (JsonProcessingException e) {
            log.error("token json error : {}", e.getMessage());
        }
        return token;
    }

    /**
     * 网关拒绝
     *
     * @param exchange
     * @return
     */
    private Mono<Void> unauthorized(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        DataBuffer buffer = response.bufferFactory().wrap(HttpStatus.UNAUTHORIZED.getReasonPhrase().getBytes());
        return response.writeWith(Flux.just(buffer));
    }

}
