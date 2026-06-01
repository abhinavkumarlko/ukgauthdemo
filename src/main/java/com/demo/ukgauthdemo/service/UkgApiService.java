package com.demo.ukgauthdemo.service;

import org.springframework.stereotype.Service;

@Service
public class UkgApiService {

    private final UkgAuthService authService;

    public UkgApiService(UkgAuthService authService) {
        this.authService = authService;
    }

    public void callUkgApi() {

        String token = authService.getValidAccessToken();

        System.out.println("Calling UKG API with token: " + token);
    }
}