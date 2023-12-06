package com.farmacia.drogariaDeVerdade.controller;

import com.farmacia.drogariaDeVerdade.model.Remedio;
import com.farmacia.drogariaDeVerdade.service.RemedioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drogaria")
public class RemedioController {

    @Autowired
    RemedioService remedioService;

    List<Remedio> remedios = new ArrayList<>();

    @GetMapping("/remedio/cadastro")
    public String exibirCadastroRemedio(Model model) {
        model.addAttribute("remedio", new Remedio());
        model.addAttribute("nomeRemedio", new Remedio());
        return "telaCadastroRemedio";
    }

    @PostMapping("/remedio/cadastro")
    public String cadastrarRemedio(@ModelAttribute("remedio") Remedio remedioCadastrado) {
        remedioService.cadastrarRemedio(remedioCadastrado);
        return "redirect:/drogaria";
    }

    @PostMapping("/remedio/pesquisa")
    public String pesquisarRemedio(@ModelAttribute("nomeRemedio") Remedio nomeRemedio, Model model) {
        Remedio remedioEncontrado = remedioService.procurarRemedio(nomeRemedio);
        List<Remedio> listRemedio = remedioService.listarRemedios();
        if (remedioEncontrado != null) {
            model.addAttribute("remedios", remedioEncontrado);
        } else {
            model.addAttribute("remedios", listRemedio);
        }
        return "telaInicial";
    }

    @GetMapping("/remedio/estoque")
    public String exibirEstoqueRemedio(Model model) {
        List<Remedio> listRemedio = remedioService.listarRemedios();
        model.addAttribute("remedios", listRemedio);
        model.addAttribute("nomeRemedio", new Remedio());
        return "telaEstoqueRemedio";
    }

    @GetMapping("/remedio/edit/{idRemedio}")
    public String editarRemedio(Model model, @PathVariable("idRemedio") Integer idRemedio) {
        List<Remedio> listRemedio = remedioService.listarRemedios();
        for (Remedio objRemedio : listRemedio) {
            if (objRemedio.getId().equals(idRemedio)) {
                model.addAttribute("remedio", objRemedio);
            }
        }
        model.addAttribute("nomeRemedio", new Remedio());
        return "telaEditRemedio";
    }

    @PostMapping("/remedio/edit/{idRemedio}")
    public String editandoRemedio(@PathVariable("idRemedio") Integer idRemedio, @ModelAttribute("remedio") Remedio remedioEditado) {
        remedioService.atualizarRemedio(idRemedio, remedioEditado);
        return "redirect:/drogaria/remedio/estoque";
    }

    @GetMapping("/remedio/deletar/{idRemedio}")
    public String deletarRemedio(@PathVariable("idRemedio") Integer idRemedio) {
        remedioService.excluir(idRemedio);
        return "redirect:/drogaria/remedio/estoque";
    }
}
