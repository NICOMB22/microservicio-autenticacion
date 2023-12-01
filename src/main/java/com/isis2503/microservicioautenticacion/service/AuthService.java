package com.isis2503.microservicioautenticacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.isis2503.microservicioautenticacion.model.Usuario;
import com.isis2503.microservicioautenticacion.repository.UsuarioRepository;

@Service
public class AuthService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean validarUsuario(String usuario, String password) {
        Usuario usuarioEncontrado = usuarioRepository.findByUsername(usuario).orElse(null);
        if (usuarioEncontrado != null) {
            return usuarioEncontrado.getPassword().equals(password);
        }
        return false;
    }

    public void registrarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }


}
