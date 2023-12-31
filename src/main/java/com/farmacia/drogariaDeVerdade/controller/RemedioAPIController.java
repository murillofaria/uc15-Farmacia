package com.farmacia.drogariaDeVerdade.controller;

import com.farmacia.drogariaDeVerdade.model.Remedio;
import com.farmacia.drogariaDeVerdade.service.RemedioService;
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
@RequestMapping("/drogaria/remedioAPI")
public class RemedioAPIController {

    @Autowired
    RemedioService remedioService;

    @PostMapping("/cadastro")
    public ResponseEntity<Remedio> adicionarRemedio(@RequestBody Remedio objRemedio) {
        Remedio remedioCadastrado = remedioService.cadastrarRemedio(objRemedio);
        return new ResponseEntity<>(remedioCadastrado, HttpStatus.CREATED);
    }

    @GetMapping("/lista")
    public ResponseEntity<List> mostrarRemedios() {
        List<Remedio> listRemedios = remedioService.listarRemedios();
        return new ResponseEntity<>(listRemedios, HttpStatus.OK);
    }

    @PostMapping("/procura")
    public ResponseEntity<Remedio> pesquisarRemedio(@RequestBody Remedio nomeRemedio) {
        Remedio objRemedio = remedioService.procurarRemedio(nomeRemedio);
        return new ResponseEntity<>(objRemedio, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Remedio> buscarRemedioPorId(@PathVariable("id") Integer idRemedio) {
        Remedio remedioEncontrado = remedioService.procurarRemedioPorId(idRemedio);
        return new ResponseEntity<>(remedioEncontrado, HttpStatus.OK);
    }

    @PutMapping("/editar/{idRemedio}")
    public ResponseEntity<Remedio> editarRemedio(@PathVariable("idRemedio") Integer idRemedio, @RequestBody Remedio remedioEditado) {
        Remedio editarRemedio = remedioService.atualizarRemedio(idRemedio, remedioEditado);
        return new ResponseEntity<>(editarRemedio, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{idRemedio}")
    public ResponseEntity<?> deletar(@PathVariable("idRemedio") Integer idRemedio) {
        remedioService.excluir(idRemedio);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
