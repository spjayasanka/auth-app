package com.example.authapp.controller;

import com.example.authapp.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/profile")
    public ResponseEntity<Map<String, Object>> getUserProfile(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof User) {
            User user = (User) authentication.getPrincipal();
            
            Map<String, Object> profile = new HashMap<>();
            profile.put("id", user.getId());
            profile.put("username", user.getUsername());
            profile.put("email", user.getEmail());
            
            return ResponseEntity.ok(profile);
        }
        
        return ResponseEntity.status(401).body(null);
    }
}