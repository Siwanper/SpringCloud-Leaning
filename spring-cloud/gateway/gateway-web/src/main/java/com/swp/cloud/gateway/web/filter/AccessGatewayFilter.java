package com.swp.cloud.gateway.web.filter;

import com.swp.cloud.client.service.IAuthService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 描述: 请求权限过滤器
 *
 * @outhor ios
 * @create 2019-11-18 5:08 PM
 */
@Configuration
@ComponentScan(basePackages = "com.swp.cloud.client")
@Slf4j
public class AccessGatewayFilter implements GlobalFilter {

    private final static String X_CLIENT_TOKEN_USER = "x-client-token-user";
    private final static String X_CLIENT_TOKEN = "x-client-token";
    private static final String BEARER = "bearer";

    @Autowired
    private IAuthService authService;

    /**
     * 1、检查token信息是否可用，如果不可用直接返回401
     * 2、如果token可用，判断请求是否有权限，如果有进入下一个filter，如果没有返回401
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String authentication = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        String url = request.getPath().value();
        String method = request.getMethodValue();
        log.debug("url:{}, method:{}, header:{}", url, method, request.getHeaders());

        if (authService.ignorlAuthentication(url)) {
            return chain.filter(exchange);
        }

        if (StringUtils.isBlank(authentication) || !authentication.startsWith(BEARER)) {
            log.debug("url:{}, method:{}, header:{}, 请求未携带token信息", url, method, request.getHeaders());
            return unauthorized(exchange);
        }

        if (authService.hasPermission(authentication, url, method)) {
            ServerHttpRequest.Builder builder = request.mutate();
            builder.header(X_CLIENT_TOKEN, "添加服务间简单认证");
            builder.header(X_CLIENT_TOKEN_USER, authService.getJwt(authentication).getClaims());
            return chain.filter(exchange.mutate().request(builder.build()).build());
        }

        return unauthorized(exchange);
    }

    /**
     * 网关拒绝
     * @param exchange
     * @return
     */
    private Mono<Void> unauthorized(ServerWebExchange exchange) {
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        DataBuffer dataBuffer = exchange.getResponse().bufferFactory().wrap(HttpStatus.UNAUTHORIZED.getReasonPhrase().getBytes());
        return exchange.getResponse().writeWith(Flux.just(dataBuffer));
    }

}
