package org.spring.example.springsecuritybusiness.config.openfeign;

import feign.codec.ErrorDecoder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableFeignClients
public class OtpClientConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new ErrorDecoder.Default();

    }

}
