package com.demo.ukgauthdemo.service;

import com.demo.ukgauthdemo.entity.AuthToken;
import com.demo.ukgauthdemo.repository.AuthTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class UkgAuthService {

    private static final String AUTH_URL =
            "http://localhost:8081/auth/login";

    private final AuthTokenRepository repository;
    private final RestTemplate restTemplate;

    public UkgAuthService(AuthTokenRepository repository,
                          RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public String getValidAccessToken() {

        AuthToken token =
                repository.findById(1L).orElse(null);

        if (token == null ||
                token.getExpiryTime().isBefore(LocalDateTime.now())) {
            return refreshToken();
        }

        return token.getAccessToken();
    }

    private String refreshToken() {

        Map<String, String> response =
                restTemplate.postForObject(
                        AUTH_URL,
                        null,
                        Map.class
                );

        AuthToken token =
                repository.findById(1L)
                        .orElse(new AuthToken());

        token.setId(1L);
        token.setAccessToken(response.get("accessToken"));
        token.setRefreshToken(response.get("refreshToken"));
        token.setExpiryTime(LocalDateTime.now().plusMinutes(1));

        repository.save(token);

        System.out.println("Fetched new token");

        return token.getAccessToken();
    }
}