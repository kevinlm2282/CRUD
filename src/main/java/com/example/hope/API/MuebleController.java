package com.example.hope.API;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.hope.BL.MuebleBL;
import com.example.hope.DAO.Entity.MuebleEntity;
import com.example.hope.DTO.MuebleDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/api/mueble")
public class MuebleController {
    private Logger LOGGER = LoggerFactory.getLogger(MuebleController.class);
    private MuebleBL muebleBL;

    @Autowired
    public MuebleController(MuebleBL muebleBL) {
        this.muebleBL = muebleBL;
    }
    // Las requests que regresa objetos DTO 
    //* */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<MuebleDTO>> obtenerMueblesDTO() {
        LOGGER.info("REQUEST: Iniciando petición para obtener el listado de Muebles");
        List<MuebleDTO> result = muebleBL.getMueblesDTO();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<MuebleDTO> obtenerMuebleDTO(@PathVariable Long id) {
        LOGGER.info("REQUEST: Iniciando petición para obtener el mueble");
        MuebleDTO result = muebleBL.getMuebleDTO(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }    
    // reque
    //* */

    // LAs request que regresan Entidades ENTITY
    //* */
    @RequestMapping(method = RequestMethod.GET, value = "/entity")
    public ResponseEntity<List<MuebleEntity>> obtenerMuebles() {
        LOGGER.info("REQUEST: Iniciando petición para obtener el listado de Muebles");
        List<MuebleEntity> result = muebleBL.getMuebles();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<MuebleEntity> saveUser(@RequestBody MuebleEntity mueble) {
        LOGGER.info("REQUEST: Iniciando petición para guardar un mueble");
        MuebleEntity result = muebleBL.postMueble(mueble);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "entity/{id}")
    public ResponseEntity<MuebleEntity> obtenerMueble(@PathVariable Long id) {
        LOGGER.info("REQUEST: Iniciando petición para obtener el mueble");
        MuebleEntity result = muebleBL.getMueble(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<MuebleEntity> actualizarMueble(@RequestBody MuebleEntity muebleEntity) {
        LOGGER.info("REQUEST: Inicio de peticion de actualizacion de mueble");
        MuebleEntity result = muebleBL.putMueble(muebleEntity);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> eliminarMueble(@PathVariable Long id) {
        LOGGER.info("REQUEST: Inicio de peticion para eliminar un mueble");
        muebleBL.deleteMueble(id);
        LOGGER.info("REQUEST: La eliminacion del mueble se realizo: ");
        return new ResponseEntity<>(HttpStatus.OK);
        
    }
    
}
