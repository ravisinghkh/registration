package com.auth.config.security;

import com.auth.domain.entity.LoginHistory;
import com.auth.domain.repository.LoginHistoryRepository;
import com.auth.domain.service.UserDetailService;
import com.auth.domain.service.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by ravink on 4/10/2016.
 */
public class CustomAuthenticationProvider extends DaoAuthenticationProvider{


    private LoginHistoryRepository loginHistoryRepository;

    @Override
    public Authentication authenticate(Authentication authentication)throws AuthenticationException{
        final Authentication authenticate = super.authenticate(authentication);
        LoginHistory history = new LoginHistory();
        UserDetails userDetails = (UserDetails) authenticate.getPrincipal();
        history.setUsername(userDetails.getUsername());
        history.setLoginTime(new Date());
        loginHistoryRepository.save(history);
        return authenticate;
    }

    public void setLoginHistoryRepository(LoginHistoryRepository loginHistoryRepository) {
        this.loginHistoryRepository = loginHistoryRepository;
    }
}
