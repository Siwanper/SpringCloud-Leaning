package com.swp.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-08-28 4:33 PM
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     *
     * @return
     */
    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.swp.swagger"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    private ApiInfo apiInfo (){
        return new ApiInfo("Swagger测试文档", "测试swagger文档在线生成", "1.0.0", "https://www.xiaomaigongkao.com", new Contact("小麦公考","https://www.xiaomaigongkao.com","xiaomaigongkao@163.com"), "Licent 2.0", "https://www.xiaomaigongkao.com", new ArrayList());
    }

}
