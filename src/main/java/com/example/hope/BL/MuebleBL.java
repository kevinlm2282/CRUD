package com.example.hope.BL;


import java.io.Console;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.example.hope.DAO.Entity.Long;
import com.example.hope.DAO.Repository.MuebleRepository;
import com.example.hope.DTO.MuebleDTO;

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

    //Metodos que regresan datos de tipo MuebleDTO
    //* */
    public List<MuebleDTO> getMueblesDTO() {
        LOGGER.info("BUSINESS-LOGIC: Se inicia la consulta para obtener el listado de muebles");
        List<MuebleDTO> listadoMuebles = new ArrayList<>();
        List<Long> listaMuebles = this.muebleRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        listaMuebles.stream().forEach(mueble->{
            MuebleDTO muebleDTO = new MuebleDTO();
            listadoMuebles.add(muebleDTO.convertToDTO(mueble));
        });
        LOGGER.info("BUSINESS-LOGIC: La respuesta de la consulta del listado de muebles es {}", listaMuebles);
        return listadoMuebles;
    }

    public MuebleDTO getMuebleDTO(Long id) {
        LOGGER.info("BUSINESS-LOGIC: Inicio de consulta de obtencion de mueble con id: " + id);
        MuebleDTO muebleDTO = new MuebleDTO();
        MuebleDTO mueble = muebleDTO.convertToDTO(this.muebleRepository.findById(id).orElseThrow());
        return mueble;
    }
    //* */

    //Metodos que regresan datos de tipo MuebleEntity



    public List<Long> getMuebles() {
        LOGGER.info("BUSINESS-LOGIC: Iniciando consulta para obtener el listado de muebles");
        List<Long> listaMuebles = this.muebleRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        LOGGER.info("BUSINESS-LOGIC: La consulta para obtener muebles regresa esto: ", listaMuebles);
        return listaMuebles;
    }

    public Long getMueble(Long id){
        LOGGER.info("BUSINNES-LOGIC: Iniciando consulta para obtener un mueble");
        Long muebleEntity = this.muebleRepository.findById(id).orElseThrow();
        LOGGER.info("BUSINNES-LOGIC: La consulta de busqueda de mueble regresa: ",muebleEntity);
        return muebleEntity;
    }

    @Transactional
    public Long postMueble(Long mueble){
        LOGGER.info("BUSINESS-LOGIC Iniciado consulta para guardar mueble");
        Long muebleEntity = this.muebleRepository.save(mueble);
        LOGGER.info("El resultado de la consulta de registro de mueble es {}:", muebleEntity);
        return muebleEntity;
    }

    public Long putMueble(Long mueble) {
        LOGGER.info("BUSINNES-LOGIC Iniciando actualizacion de mueble");
        Long muebleEntity = this.muebleRepository.findById(mueble.getId()).orElseThrow();
        System.out.println(muebleEntity);
        muebleEntity.setNombre(mueble.getNombre());
        muebleEntity.setColor(mueble.getColor());
        muebleEntity.setCantidad(mueble.getCantidad());
        muebleEntity.setPrecio(mueble.getPrecio());
        muebleEntity.setUpdatDateTime(LocalDateTime.now());
        Long actualizar = this.muebleRepository.save(muebleEntity);
        LOGGER.info("BUSINNES-LOGIC El resultado de la peticion de actualizacion es:",actualizar);
        return actualizar;
    }
    
    public void deleteMueble(Long id) {
        LOGGER.info("BUSINESS-LOGIC Iniciando peticion de eliminacion de mueble");
        this.muebleRepository.deleteById(id);
    }



    

}
