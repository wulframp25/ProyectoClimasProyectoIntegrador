package co.edu.udea.arquitectura.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;

public class FeignWeatherConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Accept", MediaType.APPLICATION_JSON_VALUE);
            requestTemplate.header("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        };
    }

}
