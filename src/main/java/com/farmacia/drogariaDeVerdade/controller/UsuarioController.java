package com.farmacia.drogariaDeVerdade.controller;

import com.farmacia.drogariaDeVerdade.model.Pergunta;
import com.farmacia.drogariaDeVerdade.model.Remedio;
import com.farmacia.drogariaDeVerdade.model.Usuario;
import com.farmacia.drogariaDeVerdade.service.RemedioService;
import com.farmacia.drogariaDeVerdade.service.UsuarioService;
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
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RemedioService remedioService;

    @GetMapping("")
    public String exibirTelaInicial(Model model) {
        List<Remedio> listRemedio = remedioService.listarRemedios();
        model.addAttribute("remedios", listRemedio);
        model.addAttribute("nomeRemedio", new Remedio());
        return "telaInicial";
    }

    @GetMapping("/usuario/cadastro")
    public String exibirCadastroUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("nomeRemedio", new Remedio());
        return "telaCadastroUsuario";
    }

    @PostMapping("/usuario/cadastro")
    public String cadastrarUsuario(@ModelAttribute("usuario") Usuario usuarioCadastrado) {
        usuarioService.cadastrarUsuario(usuarioCadastrado);
        return "redirect:/drogaria";
    }

    @GetMapping("/atendimento")
    public String atenderCliente(Model model) {
        List<Usuario> listUsuarios = usuarioService.listarUsuarios();
        if (!listUsuarios.isEmpty()) {
            Usuario ultimoUsuario = listUsuarios.get(listUsuarios.size() - 1);
            model.addAttribute("ultimoUsuario", ultimoUsuario);
        }
        model.addAttribute("nomeRemedio", new Remedio());
        model.addAttribute("pergunta", new Pergunta());
        return "telaAtendimentoCliente";
    }

    @PostMapping("/atendimento")
    public String perguntaCliente(@ModelAttribute Pergunta objPergunta) {
        if(objPergunta.getSelecionarPergunta() == 0){
            return "redirect:/drogaria/atendimento";
        }
        return "redirect:/drogaria/atendimento/" + objPergunta.getSelecionarPergunta();
    }

    @GetMapping("/atendimento/{perguntaSelecionada}")
    public String responderPergunta(@PathVariable("perguntaSelecionada") int perguntaSelecionada, Model model) {
        List<Remedio> listRemedio = remedioService.listarRemedios();
        List<Remedio> remediosPromocao = new ArrayList<>();
        for (Remedio remedioPromocao : listRemedio) {
            if (remedioPromocao.isPromocao() == true) {
                remediosPromocao.add(remedioPromocao);
            }
        }
        model.addAttribute("remediosPromocao", remediosPromocao);
        model.addAttribute("pergunta", new Pergunta());
        model.addAttribute("perguntaSelecionada", perguntaSelecionada);
        model.addAttribute("nomeRemedio", new Remedio());
        return "telaAtendimentoCliente";
    }
}
