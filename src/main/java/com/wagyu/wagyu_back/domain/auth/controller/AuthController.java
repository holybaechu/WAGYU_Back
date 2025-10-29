package com.wagyu.wagyu_back.domain.auth.controller;

import com.wagyu.wagyu_back.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("register")
    public String register() {
        return "register";
    }

    @PostMapping("login")
    public String login() {
        return "login";
    }

    @PostMapping("refresh")
    public String refresh() {
        return "refresh";
    }
}
