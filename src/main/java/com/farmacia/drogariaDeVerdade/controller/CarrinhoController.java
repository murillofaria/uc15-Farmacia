package com.farmacia.drogariaDeVerdade.controller;

import com.farmacia.drogariaDeVerdade.model.Carrinho;
import com.farmacia.drogariaDeVerdade.model.Remedio;
import com.farmacia.drogariaDeVerdade.service.CarrinhoService;
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
public class CarrinhoController {

    @Autowired
    CarrinhoService carrinhoService;

    @Autowired
    RemedioService remedioService;

    List<Remedio> listRemedioCarrinho = new ArrayList<>();

    @GetMapping("/carrinho/{idRemedio}")
    public String exibirCarrinhoId(Model model, @PathVariable("idRemedio") Integer idRemedio) {
        model.addAttribute("nomeRemedio", new Remedio());
        Carrinho carrinhoPopulado = new Carrinho();
        List<Carrinho> listCarrinho = carrinhoService.mostrarItensCarrinho();
        Remedio remedioEncontrado = remedioService.procurarRemedioPorId(idRemedio);

        for (Carrinho objCarrinho : listCarrinho) {
            if (objCarrinho.getRemedio().getId().equals(idRemedio)) {
                return "redirect:/drogaria/carrinho";
            }
        }

        carrinhoPopulado.setRemedio(remedioEncontrado);
        carrinhoService.salvarRemedioCarrinho(carrinhoPopulado);

        return "redirect:/drogaria/carrinho";
    }

    @GetMapping("/carrinho")
    public String exibirCarrinhoCompleto(Model model) {
        List<Carrinho> listCarrinho = carrinhoService.mostrarItensCarrinho();
        model.addAttribute("listCarrinho", listCarrinho);
        double totalValor = 0;
        for (int i = 0; i < listCarrinho.size(); i++) {
            totalValor = totalValor + (listCarrinho.get(i).getRemedio().getValor() * listCarrinho.get(i).getQtd_remedio());
        }
        model.addAttribute("totalValor", totalValor);
        model.addAttribute("nomeRemedio", new Remedio());
        return "telaCarrinhoCompra";
    }

    @PostMapping("/carrinho")
    public String alterarQuantidadeRemedioCarrinho(@ModelAttribute("item") Carrinho itemCarrinho, Model model) {
        carrinhoService.atualizarItemCarrinho(itemCarrinho.getId(), itemCarrinho);
        model.addAttribute("nomeRemedio", new Remedio());
        return "redirect:/drogaria/carrinho";
    }

    @GetMapping("/carrinho/deletar/{id}")
    public String deletarItemCarrinho(@PathVariable("id") Integer idItemCarrinho, Model model) {
        carrinhoService.excluirItemCarrinho(idItemCarrinho);
        model.addAttribute("nomeRemedio", new Remedio());
        return "redirect:/drogaria/carrinho";
    }

    @GetMapping("/pagamento")
    public String exibirFormaPagamento(Model model) {
        model.addAttribute("nomeRemedio", new Remedio());
        return "telaFormaPagamento";
    }

    @PostMapping("/pagamento")
    public String finalizarCompra() {
        List<Carrinho> listCarrinho = carrinhoService.mostrarItensCarrinho();
        for (int i = 0; i < listCarrinho.size(); i++) {
            carrinhoService.excluirItemCarrinho(listCarrinho.get(i).getId());
        }
        return "redirect:/drogaria";
    }
}
