package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;


public class UserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials() + "";
        if (username == null || username.equals("")) {
            return null;
        }
        if (password.equals("")) {
            return null;
        }

        //判断验证码
//        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
//        CaptchaAuthenticationDetail detail = (CaptchaAuthenticationDetail)token.getDetails();
//        if (!detail.isImageCodeIsRight()) {
//            throw new MySecurityException("验证码不正确");
//        }

        // 判断密码
        UserDetails user = userService.loadUserByUsername(username);
        if (!user.getPassword().equals(password)) {
            throw new MySecurityException("用户名或密码不正确");
        }

        //获取用户权限信息
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }


}

class MySecurityException extends AuthenticationException {

    public MySecurityException(String msg, Throwable t) {
        super(msg, t);
    }

    public MySecurityException(String msg) {
        super(msg);
    }
}
