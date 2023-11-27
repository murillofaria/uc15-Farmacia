package com.farmacia.drogariaDeVerdade.controller;

import com.farmacia.drogariaDeVerdade.model.Usuario;
import com.farmacia.drogariaDeVerdade.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drogaria")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("")
    public String exibirTelaInicial(){
        return "telaInicial";
    }
    
    @GetMapping("/usuario/cadastro")
    public String exibirCadastroUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "telaCadastroUsuario";
    }
    
    @PostMapping("/usuario/cadastro")
    public String cadastrarUsuario(@ModelAttribute("usuario") Usuario usuarioCadastrado) {
        usuarioService.cadastrarUsuario(usuarioCadastrado);
        return "redirect:/drogaria";
    }
}
