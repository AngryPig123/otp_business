package org.spring.example.springsecuritybusiness.openfeign;

import org.junit.jupiter.api.*;
import org.spring.example.springsecuritybusiness.dto.User;
import org.spring.example.springsecuritybusiness.service.gateway.OtpFeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OtpAuthenticationTest {

    @Autowired
    private OtpFeignClientService otpFeignClientService;
    private static User user;

    @BeforeAll
    static void setup() {
        user = User.builder()
                .username("first_tester")
                .password("1q2w3e4r!")
                .code("")
                .build();
    }

    @Test
    @Order(1)
    void otp_feign_client_service_user_add_test() {
        boolean b = otpFeignClientService.userAdd(user);
        Assertions.assertTrue(b);
    }

    @Test
    @Order(2)
    void otp_feign_client_service_user_auth_test() {
        String code = otpFeignClientService.userAuth(user);
        Assertions.assertNotNull(code);
        user.setCode(code);
    }

    @Test
    @Order(3)
    void otp_feign_client_service_otp_auth_test() {
        boolean b = otpFeignClientService.otpCheck(user);
        Assertions.assertTrue(b);
    }

}
