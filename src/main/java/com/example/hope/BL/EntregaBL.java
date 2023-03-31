package com.example.hope.BL;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.hope.DAO.Entity.EntregaEntity;
import com.example.hope.DAO.Repository.EntregaRepository;

import jakarta.transaction.Transactional;


@Service
public class EntregaBL {

    private Logger LOGGER = LoggerFactory.getLogger(EntregaBL.class);
    private EntregaRepository entregaRepository;

    @Autowired
    public EntregaBL(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    public List<EntregaEntity> getEntrega(){
        LOGGER.info("BUSINESS-LOGIC: Inicio de la consulta para obtener todas las entregas ");
        List<EntregaEntity> entregas = this.entregaRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
        LOGGER.info("BUSINESS-LOGIC: El resultado de la consulta de la peticion es: ", entregas);
        return entregas;
    }

    @Transactional
    public EntregaEntity postEntrega(EntregaEntity entrega) {
        LOGGER.info("entrega {}",entrega.getMuebles());
        LOGGER.info("BUSINESS-LOGIC: Inicio de la consulta para registrar una entrega");
        EntregaEntity newEntrega = this.entregaRepository.save(entrega);
        LOGGER.info("BUSINESS-LOGIC: El resultado de registro de la entrega es", newEntrega);
        return newEntrega;
    }
    
    
    

}
