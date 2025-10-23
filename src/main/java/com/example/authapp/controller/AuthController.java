package com.example.authapp.controller;

import com.example.authapp.dto.JwtResponse;
import com.example.authapp.dto.LoginRequest;
import com.example.authapp.model.User;
import com.example.authapp.service.UserService;
import com.example.authapp.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtil.generateToken(authentication.getName());

            User user = (User) authentication.getPrincipal();

             return ResponseEntity.ok(new JwtResponse(jwt, user.getId(), user.getUsername(), user.getEmail()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: Invalid username or password!");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User signUpRequest) {
        if (userService.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body("Error: Username is already taken!");
        }

        if (userService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body("Error: Email is already in use!");
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(), 
                             signUpRequest.getEmail(), 
                             passwordEncoder.encode(signUpRequest.getPassword()));

        userService.save(user);

        return ResponseEntity.ok().body("User registered successfully!");
    }
}