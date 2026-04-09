package com.example.MyApplication.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
@Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("My Diary App")
                        .description("This is the app in which,user makes it own diary which is seperate from other users ")
                        .version("1.0"));
    }
}
