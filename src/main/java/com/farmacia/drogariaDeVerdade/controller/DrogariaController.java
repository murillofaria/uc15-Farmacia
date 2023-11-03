package com.farmacia.drogariaDeVerdade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DrogariaController {
    @GetMapping("/tela_inicial")
    public String exibirTelaInicial(){
        return "telaInicial";
    }
    
    @GetMapping("/tela_cadastro_usuario")
    public String exibirCadastroUsuario(){
        return "telaCadastroUsuario";
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
