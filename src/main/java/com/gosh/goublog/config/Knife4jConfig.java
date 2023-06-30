package com.gosh.goublog.config;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/22 12:10
 * @description Knif4j配置
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class Knife4jConfig {

    @Value("${swagger.enable}")
    private Boolean enable;

    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.OAS_30)
                .enable(enable)
                .apiInfo(new ApiInfoBuilder()
                        .title("我的标题")
                        .description("我的描述")
                        // .termsOfServiceUrl("http://www.xx.com/")
                        .contact(new Contact("knife", "https://knife.blog.csdn.net/", "914135534@qq.com"))
                        .version("1.0")
                        .build())
                // 分组名称
                .groupName("all")
                .select()
                // 这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.gosh.goublog.controller"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }
}
