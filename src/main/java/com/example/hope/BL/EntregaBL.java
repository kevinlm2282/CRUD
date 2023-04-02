package com.example.hope.BL;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.hope.DAO.Entity.EntregaEntity;
import com.example.hope.DAO.Entity.Long;
import com.example.hope.DAO.Repository.EntregaRepository;
import com.example.hope.DAO.Repository.MuebleRepository;
import com.example.hope.DAO.id_class.MuebleEntregasEntity;

import jakarta.transaction.*;


@Service
public class EntregaBL {

    private Logger LOGGER = LoggerFactory.getLogger(EntregaBL.class);
    private EntregaRepository entregaRepository;
    private MuebleRepository muebleRepository;

    
    @Autowired
    public EntregaBL(EntregaRepository entregaRepository, MuebleRepository muebleRepository) {
        this.entregaRepository = entregaRepository;
        this.muebleRepository = muebleRepository;
    }

    public List<EntregaEntity> getEntrega(){
        LOGGER.info("BUSINESS-LOGIC: Inicio de la consulta para obtener todas las entregas ");
        List<EntregaEntity> entregas = this.entregaRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
        LOGGER.info("BUSINESS-LOGIC: El resultado de la consulta de la peticion es: ", entregas);
        return entregas;
    }

    // @Transactional(propagation = Propagation.REQUIRED)
    // public EntregaEntity postEntrega(EntregaEntity entrega) {
    //     LOGGER.info("entrega {}",entrega.getMuebles());
    //     EntregaEntity entregaEntity = new EntregaEntity();
    //     entregaEntity.setCliente(entrega.getCliente());
    //     entregaEntity.setFecha_entrega(entrega.getFecha_entrega());
    //     entregaEntity.setFecha_entrega_real(entrega.getFecha_entrega_real());
    //     entregaEntity.setFecha_inicio_pedido(entrega.getFecha_inicio_pedido());
    //     entregaEntity.setMuebles(entrega.getMuebles().stream().map(mueble ->{
    //         MuebleEntregasEntity muebleEntregasEntity = new MuebleEntregasEntity();
    //         MuebleEntity muebleEntity = muebleRepository.findById(mueble.getMueble().getId()).orElseThrow(()-> new RuntimeException("mueble no encontrado"));
    //         muebleEntregasEntity.setEntrega(entregaEntity);
    //         muebleEntregasEntity.setMueble(muebleEntity);
    //         muebleEntregasEntity.setCantidad(mueble.getCantidad());
    //         muebleEntity.setCantidad(muebleEntity.getCantidad() - mueble.getCantidad());
    //         muebleRepository.save(muebleEntity);
    //         return muebleEntregasEntity;
    //     }).collect(Collectors.toList()));
    //     EntregaEntity entregaGuardar =  entregaRepository.save(entregaEntity);
    //     entrega.setId(entregaGuardar.getId());
    //     // LOGGER.info("BUSINESS-LOGIC: Inicio de la consulta para registrar una entrega");
    //     // LOGGER.info("Los muebles son {}",entrega.getMuebles());
    //     // EntregaEntity newEntrega = this.entregaRepository.save(entrega);
    //     // LOGGER.info("BUSINESS-LOGIC: El resultado de registro de la entrega es", newEntrega);
    //     return entrega;
    // }

    @Transactional(propagation = Propagation.REQUIRED)
    public EntregaEntity postEntrega(EntregaEntity entrega) {
        LOGGER.info("BUSINESS-LOGIC: Inicio de la peticion de registro de entrega");
        EntregaEntity entreGuardar = new EntregaEntity();
        entreGuardar.setCliente(entrega.getCliente());
        entreGuardar.setFecha_entrega(entrega.getFecha_entrega());
        entreGuardar.setFecha_entrega_real(entrega.getFecha_entrega_real());
        entreGuardar.setFecha_inicio_pedido(entrega.getFecha_inicio_pedido());
        entreGuardar.setMuebles(
        entrega.getMuebles().stream().map(mueble->{
            MuebleEntregasEntity muebleEntregasEntity = new MuebleEntregasEntity();
            muebleEntregasEntity.setMueble(this.muebleRepository.findById(mueble.getMueble().getId()).orElseThrow());
            muebleEntregasEntity.setCantidad(mueble.getCantidad());
            muebleEntregasEntity.setEntrega(entrega);
            return muebleEntregasEntity;
        }).collect(Collectors.toList())
        );
        EntregaEntity entregaEntity = entregaRepository.save(entreGuardar);
        return entregaEntity;
    }
    
    

}
