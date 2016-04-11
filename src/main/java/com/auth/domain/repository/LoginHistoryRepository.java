package com.auth.domain.repository;

import com.auth.domain.entity.LoginHistory;
import com.auth.domain.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by ravink on 4/10/2016.
 */
public interface LoginHistoryRepository extends PagingAndSortingRepository<LoginHistory, Long> {
    List<LoginHistory> findByUsername(String username, Pageable topFive);
}
