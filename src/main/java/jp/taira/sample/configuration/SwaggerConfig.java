package jp.taira.sample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        var openApi = new OpenAPI();
        var info = new Info();
        info.title("title");
        info.version("1.0");

        openApi.info(info);

        return openApi;
    }

}
