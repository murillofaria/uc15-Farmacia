package com.farmacia.drogariaDeVerdade.repository;

import com.farmacia.drogariaDeVerdade.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
