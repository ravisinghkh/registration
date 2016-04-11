package com.auth.domain.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ravink on 4/7/2016.
 */
@Entity
@Table(name = "USER")
public class User {
    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long userId;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "created")
    private Date created;

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreated() {
        return created;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
