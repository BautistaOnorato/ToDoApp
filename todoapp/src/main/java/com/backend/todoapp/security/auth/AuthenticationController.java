package com.backend.todoapp.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) throws Exception {
        try {
            return ResponseEntity.ok(authenticationService.register(registerRequest));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
