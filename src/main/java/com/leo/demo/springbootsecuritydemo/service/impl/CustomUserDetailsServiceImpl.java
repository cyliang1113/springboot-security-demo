package com.leo.demo.springbootsecuritydemo.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

public class CustomUserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorities = new LinkedList<>();
        if ("admin".equals(username)) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("/userInfo");
            grantedAuthorities.add(grantedAuthority);
        }
        User user = new User(username, "", grantedAuthorities);
        return user;
    }
}
