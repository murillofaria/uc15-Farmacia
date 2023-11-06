package com.farmacia.drogariaDeVerdade.controller;

import com.farmacia.drogariaDeVerdade.model.Remedio;
import com.farmacia.drogariaDeVerdade.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DrogariaController {
    
    public List<Remedio> remedios = new ArrayList<>();
    
    @GetMapping("/tela_inicial")
    public String exibirTelaInicial(Model model){
        model.addAttribute("remedios", remedios);
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
    public String exibirCadastroRemedio(Model model){
        model.addAttribute("remedio", new Remedio());
        return "telaCadastroRemedio";
    }
    
    @PostMapping("/tela_cadastro_remedio")
    public String cadastrarRemedio(@ModelAttribute Remedio remedio){
        remedios.add(remedio);
        return "redirect:/tela_inicial";
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
