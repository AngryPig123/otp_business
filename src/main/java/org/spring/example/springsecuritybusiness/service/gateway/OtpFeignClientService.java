package org.spring.example.springsecuritybusiness.service.gateway;

import org.spring.example.springsecuritybusiness.dto.User;

public interface OtpFeignClientService {
    boolean userAdd(User user);

    String userAuth(User user);

    boolean otpCheck(User user);
}
