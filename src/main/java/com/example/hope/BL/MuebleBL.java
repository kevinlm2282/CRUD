package com.example.hope.BL;


import java.io.Console;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.example.hope.DAO.Entity.MuebleEntity;
import com.example.hope.DAO.Repository.MuebleRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class MuebleBL {
    private Logger LOGGER = LoggerFactory.getLogger(MuebleBL.class);
    private MuebleRepository muebleRepository;

    @Autowired
    public MuebleBL(MuebleRepository muebleRepository) {
        this.muebleRepository = muebleRepository;
    }

    public List<MuebleEntity> getMuebles() {
        LOGGER.info("BUSINESS-LOGIC: Iniciando consulta para obtener el listado de muebles");
        List<MuebleEntity> listaMuebles = this.muebleRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        LOGGER.info("BUSINESS-LOGIC: La consulta para obtener muebles regresa esto: ", listaMuebles);
        return listaMuebles;
    }

    public MuebleEntity getMueble(Long id){
        LOGGER.info("BUSINNES-LOGIC: Iniciando consulta para obtener un mueble");
        MuebleEntity muebleEntity = this.muebleRepository.findById(id).orElseThrow();
        LOGGER.info("BUSINNES-LOGIC: La consulta de busqueda de mueble regresa: ",muebleEntity);
        return muebleEntity;
    }

    @Transactional
    public MuebleEntity postMueble(MuebleEntity mueble){
        LOGGER.info("BUSINESS-LOGIC Iniciado consulta para guardar mueble");
        MuebleEntity muebleEntity = this.muebleRepository.save(mueble);
        LOGGER.info("El resultado de la consulta de registro de mueble es {}:", muebleEntity);
        return muebleEntity;
    }

    public MuebleEntity putMueble(MuebleEntity mueble) {
        LOGGER.info("BUSINNES-LOGIC Iniciando actualizacion de mueble");
        MuebleEntity muebleEntity = this.muebleRepository.findById(mueble.getId()).orElseThrow();
        System.out.println(muebleEntity);
        muebleEntity.setNombre(mueble.getNombre());
        muebleEntity.setColor(mueble.getColor());
        muebleEntity.setCantidad(mueble.getCantidad());
        muebleEntity.setPrecio(mueble.getPrecio());
        muebleEntity.setUpdatDateTime(LocalDateTime.now());
        MuebleEntity actualizar = this.muebleRepository.save(muebleEntity);
        LOGGER.info("BUSINNES-LOGIC El resultado de la peticion de actualizacion es:",actualizar);
        return actualizar;
    }
    
    public void deleteMueble(Long id) {
        LOGGER.info("BUSINESS-LOGIC Iniciando peticion de eliminacion de mueble");
        this.muebleRepository.deleteById(id);
    }



    

}
