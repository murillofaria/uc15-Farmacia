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
            totalValor = totalValor + listCarrinho.get(i).getRemedio().getValor();
        }
        model.addAttribute("totalValor", totalValor);
        model.addAttribute("nomeRemedio", new Remedio());
        return "telaCarrinhoCompra";
    }
    
    @PostMapping("/carrinho/{id_carrinho}")
    public String alterarQuantidadeRemedioCarrinho(@PathVariable("id_carrinho") int idCarrinho, @ModelAttribute("item") Carrinho itemCarrinho, Model model){
        carrinhoService.atualizarItemCarrinho(idCarrinho, itemCarrinho);
        model.addAttribute("nomeRemedio", new Remedio());
        return "redirect:/drogaria/carrinho";
    }
    
    @GetMapping("/carrinho/deletar/{id}")
    public String deletarItemCarrinho(@PathVariable("id") Integer idItemCarrinho){
        carrinhoService.excluirItemCarrinho(idItemCarrinho);
        return "redirect:/drogaria/carrinho";
    }

    /*@GetMapping("/carrinho/{idRemedio}")
    public String exibirCarrinhoId(Model model, @PathVariable("idRemedio") Integer idRemedio) {
        model.addAttribute("nomeRemedio", new Remedio());
        List<Remedio> listRemedio = remedioService.listarRemedios();
        for (Remedio objRemedio : listRemedio) {
            int objRemedioId = objRemedio.getId();
            if (objRemedioId == idRemedio && !remedios.contains(objRemedio)) {
                remedios.add(objRemedio);
            }
        }
        return "redirect:/drogaria/carrinho";
    }
    
    @GetMapping("/carrinho")
    public String exibirCarrinhoCompleto(Model model) {
        model.addAttribute("nomeRemedio", new Remedio());
        model.addAttribute("remedios", remedios);
        if(!remedios.isEmpty()){
            for(int i=0; i < remedios.size(); i++){
                total = remedios.get(i).getValor() + total;
                model.addAttribute("totalValor", total);
            }
        }
        return "telaCarrinhoCompra";
    }

    @GetMapping("/carrinho/deletar/{idRemedio}")
    public String deletarItemCarrinho(Model model, @PathVariable("idRemedio") Integer idRemedio) {
        model.addAttribute("nomeRemedio", new Remedio());
        List<Remedio> listRemedio = remedioService.listarRemedios();
        for (int i = 0; i < listRemedio.size(); i++) {
            if(listRemedio.get(i).getId().equals(idRemedio)){
                if(total > listRemedio.get(i).getValor()){
                    total = total - listRemedio.get(i).getValor();
                }else{
                    total = listRemedio.get(i).getValor() - total;
                }
                remedios.remove(listRemedio.get(i));
            }
        }
        return "redirect:/drogaria/carrinho";
    }

    @GetMapping("/pagamento")
    public String exibirFormaPagamento(Model model) {
        model.addAttribute("nomeRemedio", new Remedio());
        return "telaFormaPagamento";
    }*/
}
