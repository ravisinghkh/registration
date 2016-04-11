package com.auth.config.security;

import com.auth.domain.entity.LoginHistory;
import com.auth.domain.entity.User;
import com.auth.domain.repository.LoginHistoryRepository;
import com.auth.domain.service.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by ravink on 4/9/2016.
 */
@Component
public class SessionTracker implements AuthenticationSuccessHandler{

    @Autowired
    LoginHistoryRepository loginHistoryRepository;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        LoginHistory history = new LoginHistory();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        history.setUsername(userDetails.getUsername());
        history.setLoginTime(new Date());
        loginHistoryRepository.save(history);
        httpServletResponse.sendRedirect("/loginhistory");
    }
}
