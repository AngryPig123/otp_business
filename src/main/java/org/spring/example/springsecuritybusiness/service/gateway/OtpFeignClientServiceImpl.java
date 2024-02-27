package org.spring.example.springsecuritybusiness.service.gateway;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.example.springsecuritybusiness.dto.User;
import org.spring.example.springsecuritybusiness.gateway.OtpAuthenticationGateWay;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@Slf4j
@Service
@RequiredArgsConstructor
public class OtpFeignClientServiceImpl implements OtpFeignClientService {

    private final OtpAuthenticationGateWay gateWay;

    @Override
    public boolean userAdd(User user) {
        try {
            gateWay.userAdd(user.toOtpUser());
            return true;
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("Failed to get resource = ", e);
            return false;
        }
    }

    @Override
    public String userAuth(User user) {
        try {
            return gateWay.userAuth(user.toOtpUser());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("Failed to get resource = ", e);
            throw e;
        }
    }

    @Override
    public boolean otpCheck(User user) {
        try {
            gateWay.otpCheck(user.toOtp());
            return true;
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("Failed to get resource = ", e);
            return false;
        }
    }

}
