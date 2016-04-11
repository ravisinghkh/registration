package com.auth.domain.repository;

import com.auth.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ravink on 4/7/2016.
 */
public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
