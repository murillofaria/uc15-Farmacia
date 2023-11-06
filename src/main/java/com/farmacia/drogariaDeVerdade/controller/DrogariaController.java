package com.farmacia.drogariaDeVerdade.controller;

import com.farmacia.drogariaDeVerdade.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DrogariaController {
    @GetMapping("/tela_inicial")
    public String exibirTelaInicial(){
        return "telaInicial";
    }
    
    @GetMapping("/tela_cadastro_usuario")
    public String exibirCadastroUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "telaCadastroUsuario";
    }
    
    @PostMapping("/tela_cadastro_usuario")
    public String cadastrarUsuario(){
        return "redirect:/tela_cadastro_remedio";
    }
    
    @GetMapping("/tela_cadastro_remedio")
    public String exibirCadastroRemedio(){
        return "telaCadastroRemedio";
    }
    
    @GetMapping("/tela_carrinho_compra")
    public String exibirCarrinhoCompra(){
        return "telaCarrinhoCompra";
    }
    
    @GetMapping("/tela_forma_pagamento")
    public String exibirFormaPagamento(){
        return "telaFormaPagamento";
    }
}
