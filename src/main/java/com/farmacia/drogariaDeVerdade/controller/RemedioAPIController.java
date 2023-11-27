package com.farmacia.drogariaDeVerdade.controller;

import com.farmacia.drogariaDeVerdade.model.Remedio;
import com.farmacia.drogariaDeVerdade.service.RemedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drogaria/remedio")
public class RemedioAPIController {

    @Autowired
    RemedioService remedioService;

    @PostMapping("/cadastro")
    public ResponseEntity<Remedio> adicionarRemedio(@RequestBody Remedio objRemedio) {
        Remedio remedioCadastrado = remedioService.cadastrarRemedio(objRemedio);
        return new ResponseEntity<>(remedioCadastrado, HttpStatus.CREATED);
    }

}
