package com.isis2503.microservicioautenticacion.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isis2503.microservicioautenticacion.model.Usuario;
import com.isis2503.microservicioautenticacion.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public boolean login(@RequestBody Map<String, String> credentials) {
        String usuario = credentials.get("username");
        String password = credentials.get("password");
        return authService.validarUsuario(usuario, password);
    }


    @PostMapping("/register")
    public void register(@RequestBody Usuario usuario) {
        authService.registrarUsuario(usuario);
    }
    
}
