package com.farmacia.drogariaDeVerdade.service;

import com.farmacia.drogariaDeVerdade.model.Remedio;
import com.farmacia.drogariaDeVerdade.repository.RemedioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemedioService {

    @Autowired
    RemedioRepository remedioRepository;

    public Remedio cadastrarRemedio(Remedio objRemedio) {
        objRemedio.setId(null);
        remedioRepository.save(objRemedio);
        return objRemedio;
    }
    
    public List<Remedio> listarRemedios(){
        return remedioRepository.findAll();
    }

}
