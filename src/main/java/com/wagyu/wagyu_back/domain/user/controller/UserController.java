package com.wagyu.wagyu_back.domain.user.controller;

import com.wagyu.wagyu_back.domain.user.dto.response.UserProfileResponseDTO;
import com.wagyu.wagyu_back.domain.user.service.UserService;
import com.wagyu.wagyu_back.global.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("me")
    public ResponseEntity<ApiResponse<UserProfileResponseDTO>> getProfile(Authentication authentication) {
        return ResponseEntity.ok(ApiResponse.success(userService.getUserProfile(authentication.getName())));
    }
}
