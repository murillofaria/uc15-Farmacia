package com.farmacia.drogariaDeVerdade.controller;

import com.farmacia.drogariaDeVerdade.model.Carrinho;
import com.farmacia.drogariaDeVerdade.service.CarrinhoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drogaria/carrinhoAPI")
public class CarrinhoAPIController {

    @Autowired
    CarrinhoService carrinhoService;

    @PostMapping("/comprar")
    public ResponseEntity<Carrinho> comprarRemedio(@RequestBody Carrinho remedioCarrinho) {
        carrinhoService.salvarRemedioCarrinho(remedioCarrinho);
        return new ResponseEntity<>(remedioCarrinho, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List> listarItensCarrinho() {
        List<Carrinho> listCarrinho = carrinhoService.mostrarItensCarrinho();
        return new ResponseEntity<>(listCarrinho, HttpStatus.OK);
    }

    @GetMapping("/procurar/{id}")
    public ResponseEntity<Carrinho> procurarCarrinhoPorId(@PathVariable("id") Integer idCarrinho) {
        Carrinho carrinhoEncontrado = carrinhoService.buscarCarrinhoPorId(idCarrinho);
        return new ResponseEntity<>(carrinhoEncontrado, HttpStatus.OK);
    }

    @PutMapping("/mudar/{id}")
    public ResponseEntity<Carrinho> mudarItemCarrinho(@PathVariable("id") Integer id, @RequestBody Carrinho itemCarrinho) {
        Carrinho itemCarrinhoEditado = carrinhoService.atualizarItemCarrinho(id, itemCarrinho);
        return new ResponseEntity<>(itemCarrinhoEditado, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Integer id) {
        carrinhoService.excluirItemCarrinho(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
