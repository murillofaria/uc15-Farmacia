package com.farmacia.drogariaDeVerdade.service;

import com.farmacia.drogariaDeVerdade.model.Usuario;
import com.farmacia.drogariaDeVerdade.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario objUsuario) {
        objUsuario.setId(null);
        usuarioRepository.save(objUsuario);
        return objUsuario;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

}
