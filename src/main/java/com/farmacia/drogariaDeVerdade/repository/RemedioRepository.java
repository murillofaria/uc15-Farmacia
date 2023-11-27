package com.farmacia.drogariaDeVerdade.repository;

import com.farmacia.drogariaDeVerdade.model.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemedioRepository extends JpaRepository<Remedio, Integer>{
    
}
