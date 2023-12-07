package com.farmacia.drogariaDeVerdade.controller;

import com.farmacia.drogariaDeVerdade.model.Usuario;
import com.farmacia.drogariaDeVerdade.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drogaria/usuarioAPI")
public class UsuarioAPIController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> adicionarUsuario(@RequestBody Usuario objUsuario) {
        Usuario usuarioCadastrado = usuarioService.cadastrarUsuario(objUsuario);
        return new ResponseEntity<>(usuarioCadastrado, HttpStatus.CREATED);
    }

    @GetMapping("/lista")
    public ResponseEntity<List> mostrarUsuarios() {
        List<Usuario> listUsuarios = usuarioService.listarUsuarios();
        return new ResponseEntity<>(listUsuarios, HttpStatus.OK);
    }
}
