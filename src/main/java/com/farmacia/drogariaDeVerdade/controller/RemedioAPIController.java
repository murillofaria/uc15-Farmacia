package com.farmacia.drogariaDeVerdade.controller;

import com.farmacia.drogariaDeVerdade.model.Remedio;
import com.farmacia.drogariaDeVerdade.service.RemedioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
