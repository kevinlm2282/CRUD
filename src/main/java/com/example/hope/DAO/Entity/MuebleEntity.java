package com.example.hope.DAO.Entity;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.hope.DAO.id_class.MuebleEntregasEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "mueble",schema = "hope")
public class MuebleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mueble_generator")
    @SequenceGenerator(name = "mueble_generator", allocationSize = 1 ,schema = "hope")
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "color", nullable = false)
    private String color;
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    @Column(name = "precio", nullable = false)
    private Double precio;
    @CreationTimestamp
    private LocalDateTime creatioDateTime;
    @UpdateTimestamp
    private LocalDateTime updatDateTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mueble", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MuebleEntregasEntity> entregas = new ArrayList<>();
    // @OneToMany(mappedBy = "mueble")
    // private List<MuebleEntregasEntity> entregados = new ArrayList<>();

    public MuebleEntity(Long id, String nombre, String color, Integer cantidad, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "MuebleEntity [id=" + id + ", nombre=" + nombre + ", color=" + color + ", cantidad=" + cantidad
                + ", precio=" + precio + ", creatioDateTime=" + creatioDateTime + ", updatDateTime=" + updatDateTime
                + "]";
    }


    



    
}
