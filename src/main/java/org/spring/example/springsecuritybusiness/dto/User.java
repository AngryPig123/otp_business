package org.spring.example.springsecuritybusiness.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class User {

    private String username;
    private String password;
    private String code;

    @Builder
    public User(String username, String password, String code) {
        this.username = username;
        this.password = password;
        this.code = code;
    }

    public OtpUser toOtpUser() {
        return OtpUser.builder()
                .username(username)
                .password(password)
                .build();
    }

    public Otp toOtp() {
        return Otp.builder()
                .username(username)
                .code(code)
                .build();
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class OtpUser {
        private String username;
        private String password;

        @Builder
        public OtpUser(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class Otp {
        private String username;
        private String code;

        @Builder
        public Otp(String username, String code) {
            this.username = username;
            this.code = code;
        }
    }

}
