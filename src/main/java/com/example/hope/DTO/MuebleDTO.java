package com.example.hope.DTO;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

import com.example.hope.DAO.Entity.Long;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MuebleDTO {
    
    private Long id;
    private String nombre;
    private String color;
    private Integer cantidad;

    //No es necesario el constructor ya que usa las variables de la clase 

    // public MuebleDTO(Long id, String nombre, String color, Integer cantidad) {
    //     this.id = id;
    //     this.nombre = nombre;
    //     this.color = color;
    //     this.cantidad = cantidad;
    // }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public MuebleDTO convertToDTO(Long muebEntity) {
        MuebleDTO muebleDTO = modelMapper().map(muebEntity, MuebleDTO.class);
        return muebleDTO;
    }

    public Long convertToEntity(MuebleDTO muebleDTO) {
        Long muebleEntity = modelMapper().map(muebleDTO, Long.class);
        return muebleEntity;
    }

    
}
