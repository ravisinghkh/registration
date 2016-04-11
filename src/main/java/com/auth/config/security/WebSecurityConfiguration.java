package com.auth.config.security;

import com.auth.domain.repository.LoginHistoryRepository;
import com.auth.domain.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by ravink on 4/7/2016.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    UserDetailService userDetailService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    LoginHistoryRepository loginHistoryRepository;
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        final CustomAuthenticationProvider customAuthenticationProvider = customAuthenticationProvider();
        auth.authenticationProvider(customAuthenticationProvider);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/index").permitAll()
                .antMatchers("/register").permitAll()
                .anyRequest().hasRole("USER")
                .and()
                .httpBasic();
    }

    public CustomAuthenticationProvider customAuthenticationProvider(){
        final CustomAuthenticationProvider customAuthenticationProvider = new CustomAuthenticationProvider();
        customAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        customAuthenticationProvider.setUserDetailsService(userDetailService);
        customAuthenticationProvider.setLoginHistoryRepository(loginHistoryRepository);
        return customAuthenticationProvider;
    }
}
