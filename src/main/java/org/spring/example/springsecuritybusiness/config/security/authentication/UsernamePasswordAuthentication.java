package org.spring.example.springsecuritybusiness.config.security.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UsernamePasswordAuthentication extends UsernamePasswordAuthenticationToken {

    //  생성자가 2, 3 개인 경우 확인

    public UsernamePasswordAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }   //  인증 인스턴스가 인증된 상태, authorities 해당 필드는 완료된 인증 프로세스에서 필수.

    public UsernamePasswordAuthentication(Object principal, Object credentials) {
        super(principal, credentials);
    }   //  인증 인스턴스가 인증되지 않은 상태로 유지됨

}
