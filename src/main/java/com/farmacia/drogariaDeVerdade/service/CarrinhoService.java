package com.farmacia.drogariaDeVerdade.service;

import com.farmacia.drogariaDeVerdade.model.Carrinho;
import com.farmacia.drogariaDeVerdade.repository.CarrinhoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {

    @Autowired
    CarrinhoRepository carrinhoRepository;

    public Carrinho salvarRemedioCarrinho(Carrinho remedioCarrinho) {
        remedioCarrinho.setId(null);
        carrinhoRepository.save(remedioCarrinho);
        return remedioCarrinho;
    }

    public List<Carrinho> mostrarItensCarrinho() {
        return carrinhoRepository.findAll();
    }

    public Carrinho buscarCarrinhoPorId(Integer idCarrinho) {
        return carrinhoRepository.findById(idCarrinho).orElseThrow();
    }

    public Carrinho atualizarItemCarrinho(Integer idCarrinho, Carrinho carrinhoEnviado) {
        Carrinho carrinhoEncontrado = buscarCarrinhoPorId(idCarrinho);
        carrinhoEncontrado.setQtd_remedio(carrinhoEnviado.getQtd_remedio());
        carrinhoRepository.save(carrinhoEncontrado);
        return carrinhoEncontrado;
    }

    public void excluirItemCarrinho(Integer id) {
        Carrinho itemEncontrado = buscarCarrinhoPorId(id);
        carrinhoRepository.deleteById(itemEncontrado.getId());
    }
}
