package com.soft2242.one.base.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger配置
 *
 * @author ao&dl
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userApi() {
        String[] paths = {"/**"};
        String[] packagedToMatch = {"com.soft2242.one"};
        return GroupedOpenApi.builder().group("smart-community-admin-api")
                .pathsToMatch(paths)
                .packagesToScan(packagedToMatch).build();
    }

    @Bean
    public OpenAPI customOpenApi() {
        Contact contact = new Contact();
        contact.setName("web2@gmail.com");

        return new OpenAPI().info(new Info()
                .title("智慧社区后台管理平台接口")
                .description("智慧社区后台管理平台接口")
                .contact(contact)
                .version("1.0"));
    }

}