package org.spring.example.springsecuritybusiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringSecurityBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityBusinessApplication.class, args);
    }

}
