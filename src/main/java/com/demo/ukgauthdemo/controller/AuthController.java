package com.demo.ukgauthdemo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public Map<String, String> login() {

        return Map.of(
                "accessToken",
                "demo-access-" + System.currentTimeMillis(),

                "refreshToken",
                "demo-refresh-token"
        );
    }
}