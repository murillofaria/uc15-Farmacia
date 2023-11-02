package com.farmacia.drogariaDeVerdade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DrogariaController {
    @GetMapping("/tela_inicial")
    public String exibirTelaInicial(){
        return "telaInicial";
    }
}
