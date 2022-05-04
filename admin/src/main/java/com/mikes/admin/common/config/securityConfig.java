package com.mikes.admin.common.config;

import com.mikes.admin.security.CustomLogoutSuccessHandler;
import com.mikes.admin.security.LoginFailureHandler;
import com.mikes.admin.security.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class securityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private LoginSuccessHandler loginSuccessHandler; //认证成功结果处理器
    @Resource
    private LoginFailureHandler loginFailureHandler; //认证失败结果处理器

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();

        http.authorizeRequests()
                .antMatchers("/500").permitAll()
                .antMatchers("/403").permitAll()
                .antMatchers("/404").permitAll()
                .anyRequest() //任何其它请求
                .authenticated() //都需要身份认证
                .and()
            .formLogin() //使用表单认证方式
                .loginPage("/login")
                .loginProcessingUrl("/doLogin")//配置默认登录入口
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
                .successHandler(loginSuccessHandler)//使用自定义的成功结果处理器
                .failureHandler(loginFailureHandler)//使用自定义失败的结果处理器
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new CustomLogoutSuccessHandler())
                .permitAll()
                .and()
            .sessionManagement()
                .invalidSessionUrl("/login")
                .and().csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //配置静态文件不需要认证
        web.ignoring().antMatchers("/static/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        // 使用BCrypt加密密码
        return new BCryptPasswordEncoder();
    }
}
