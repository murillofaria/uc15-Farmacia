package com.farmacia.drogariaDeVerdade.controller;

import com.farmacia.drogariaDeVerdade.model.Remedio;
import com.farmacia.drogariaDeVerdade.service.RemedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drogaria")
public class RemedioController {

    @Autowired
    RemedioService remedioService;

    @GetMapping("/remedio/cadastro")
    public String exibirCadastroRemedio(Model model) {
        model.addAttribute("remedio", new Remedio());
        return "telaCadastroRemedio";
    }
    
    @PostMapping("/remedio/cadastro")
    public String cadastrarRemedio(@ModelAttribute("remedio") Remedio remedioCadastrado){
        remedioService.cadastrarRemedio(remedioCadastrado);
        return "redirect:/drogaria";
    }
}
