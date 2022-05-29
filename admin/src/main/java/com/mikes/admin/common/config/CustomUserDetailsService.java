package com.mikes.admin.common.config;

import com.mikes.admin.entity.system.user.UserInfo;
import com.mikes.admin.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Resource
    private UserService userService;

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
        return userInfo;
    }
}
