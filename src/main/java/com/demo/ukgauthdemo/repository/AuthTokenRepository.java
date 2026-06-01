package com.demo.ukgauthdemo.repository;

import com.demo.ukgauthdemo.entity.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthTokenRepository
        extends JpaRepository<AuthToken, Long> {
}