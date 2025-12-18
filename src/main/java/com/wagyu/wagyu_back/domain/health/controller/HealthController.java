package com.wagyu.wagyu_back.domain.health.controller;

import com.wagyu.wagyu_back.global.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/health")
public class HealthController {
    @GetMapping
    public String health() {
        return "im ok genchana";
    }
}
