package com.auth.domain.service;

import com.auth.config.db.DBConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by ravink on 4/8/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DomainTestConfiguration.class, DBConfiguration.class})
public class UserDetailServiceTest {
    @Autowired
    UserDetailService userDetailService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test(expected = UsernameNotFoundException.class)
    public void testLoadUserUsernameNotFound() throws Exception {
        userDetailService.loadUserByUsername("test");
    }

    @Test
    public void testLoadUserByUsernameUserExists() throws Exception {
        final String testUsername = "testuser";
        UserDetails testUser = userDetailService.loadUserByUsername(testUsername);
        Assert.assertEquals(testUsername, testUser.getUsername());
        final String password = "Test@1<2";
        boolean matches = passwordEncoder.matches(password, testUser.getPassword());
        Assert.assertTrue(matches);

    }

}