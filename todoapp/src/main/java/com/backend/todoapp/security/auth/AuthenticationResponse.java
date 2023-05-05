package com.backend.todoapp.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private String token;
}
