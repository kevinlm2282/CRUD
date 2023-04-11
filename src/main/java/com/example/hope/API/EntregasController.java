package com.example.hope.API;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hope.BL.EntregaBL;
import com.example.hope.DAO.Entity.EntregaEntity;

import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/api/entrega")
public class EntregasController {

    private Logger LOGGER = LoggerFactory.getLogger(EntregasController.class);
    private EntregaBL entregaBL;

    @Autowired
    public EntregasController(EntregaBL entregaBL) {
        this.entregaBL = entregaBL;
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<EntregaEntity>> obtenerPedidos() {
        LOGGER.info("REQUEST: Se inicio la peticion para obtener todos los pedidos");
        List<EntregaEntity> result = entregaBL.getEntrega();
        LOGGER.info("REQUEST: La respuesta de la consulta es: ", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    // @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<EntregaEntity> saveUser(@RequestBody EntregaEntity entrega) {
        LOGGER.info("REQUEST: Iniciando petición para guardar una entrega",entrega);
        EntregaEntity result = entregaBL.postEntrega(entrega);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
