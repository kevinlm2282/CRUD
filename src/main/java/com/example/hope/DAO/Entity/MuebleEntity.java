package com.example.hope.DAO.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name = "mueble",schema = "entregas")
public class MuebleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "color", nullable = false)
    private String color;
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    public MuebleEntity(Long id, String nombre, String color, Integer cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.cantidad = cantidad;
    }

    



    
}
