package org.spring.example.springsecuritybusiness.gateway;

import org.spring.example.springsecuritybusiness.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "otp", url = "${auth.otp}")
public interface OtpAuthenticationGateWay {
    @PostMapping(path = "/user/add")
    void userAdd(User.OtpUser otpUser);

    @PostMapping(path = "/user/auth")
    String userAuth(User.OtpUser otpUser);

    @PostMapping(path = "/otp/check")
    void otpCheck(User.Otp otp);

}
