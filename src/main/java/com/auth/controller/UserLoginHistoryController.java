package com.auth.controller;

import com.auth.domain.entity.LoginHistory;
import com.auth.domain.repository.LoginHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**
 * Created by ravink on 4/10/2016.
 */
@RestController
@RequestMapping(path = "/loginhistory")
public class UserLoginHistoryController {

    @Autowired
    LoginHistoryRepository loginHistoryRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<LoginHistory>> userLoginHistory(Principal principal){
        Pageable topFive = new PageRequest(0, 5, Sort.Direction.DESC, "loginTime");
        List<LoginHistory> loginHistory = loginHistoryRepository.findByUsername(principal.getName(), topFive);
        return new ResponseEntity(loginHistory, HttpStatus.OK);
    }
}
