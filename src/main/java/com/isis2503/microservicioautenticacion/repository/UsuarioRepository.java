package com.isis2503.microservicioautenticacion.repository;

import com.isis2503.microservicioautenticacion.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String usuario);
    
}
