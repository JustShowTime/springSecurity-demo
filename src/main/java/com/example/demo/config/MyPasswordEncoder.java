package com.example.demo.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author   czq
 * @Date 2020-06-19 14:58:01    
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
