package com.farmacia.drogariaDeVerdade.repository;

import com.farmacia.drogariaDeVerdade.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer>{
    
}
