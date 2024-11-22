package com.hackathon.springbootserver.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class SwaggerConfig {
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.hackathon.springbootserver")) // 기본 패키지 경로 설정
//                .paths(PathSelectors.any()) // 모든 경로 포함
//                .build()
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        String description = "해커톤 API 문서";
//        return new ApiInfoBuilder()
//                .title("Hackathon API Documentation")
//                .description(description)
//                .version("1.0")
//                .build();
//    }
//}