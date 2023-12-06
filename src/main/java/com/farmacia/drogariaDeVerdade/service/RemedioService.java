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

    public List<Remedio> listarRemedios() {
        return remedioRepository.findAll();
    }

    public Remedio procurarRemedio(Remedio nomeRemedio) {
        List<Remedio> listRemedio = listarRemedios();
        for (Remedio objRemedio : listRemedio) {
            if (objRemedio.getNome().equals(nomeRemedio.getNome())) {
                return objRemedio;
            }
        }
        return null;
    }

    public Remedio procurarRemedioPorId(Integer idRemedio) {
        return remedioRepository.findById(idRemedio).orElseThrow();
    }

    public Remedio atualizarRemedio(Integer idRemedio, Remedio remedioEnviado) {
        Remedio remedioEncontrado = procurarRemedioPorId(idRemedio);
        remedioEncontrado.setNome(remedioEnviado.getNome());
        remedioEncontrado.setDescricao(remedioEnviado.getDescricao());
        remedioEncontrado.setValor(remedioEnviado.getValor());
        remedioEncontrado.setQtd_estoque(remedioEnviado.getQtd_estoque());
        remedioEncontrado.setPromocao(remedioEnviado.isPromocao());
        remedioRepository.save(remedioEncontrado);
        return remedioEncontrado;
    }
    
    public void excluir(Integer idRemedio){
        Remedio remedioEncontrado = procurarRemedioPorId(idRemedio);
        remedioRepository.deleteById(remedioEncontrado.getId());
    }

}
