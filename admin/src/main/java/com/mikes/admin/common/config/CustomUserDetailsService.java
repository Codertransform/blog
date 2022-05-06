package com.mikes.admin.common.config;

import com.mikes.admin.entity.user.UserInfo;
import com.mikes.admin.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Resource
    private UserService userService;

    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo info = new UserInfo();
        info.setUsername(username);
        UserInfo userInfo = userService.get(info);
        if (userInfo == null){
            throw new UsernameNotFoundException("not found");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userInfo.getRole()));
        userInfo.setAuthorities(authorities);
        System.out.println(userInfo);
        HttpSession session = request.getSession();
        session.setAttribute(username,userInfo);
        return userInfo;
    }
}
