package com.example.hope.DAO.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "entregas",schema = "hope")
public class EntregaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entrega_sequence")
    @SequenceGenerator(name = "entrega_sequence", allocationSize = 1, schema = "hope")
    @Column(name = "id")
    private Long id;
    @Column(name = "fecha_entrega")
    private Date fecha_entrega;
    @Column(name = "fecha_entrega_real")
    private Date fecha_entrega_real;
    @Column(name = "fecha_inicio_pedido")
    private Date fecha_inicio_pedido;
    @Column(name = "cliente")
    private String cliente;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "entrega", fetch = FetchType.LAZY)
    private List<MuebleEntregasEntity> muebles = new ArrayList<>();

    public EntregaEntity(Long id, Date fecha_entrega, Date fecha_entrega_real, Date fecha_inicio_pedido,
            String cliente) {
        this.id = id;
        this.fecha_entrega = fecha_entrega;
        this.fecha_entrega_real = fecha_entrega_real;
        this.fecha_inicio_pedido = fecha_inicio_pedido;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "EntregaEntity [id=" + id + ", fecha_entrega=" + fecha_entrega + ", fecha_entrega_real="
                + fecha_entrega_real + ", fecha_inicio_pedido=" + fecha_inicio_pedido + ", cliente=" + cliente + "]";
    }

    // @Override
    // public String toString() {
    //     return "EntregaEntity [id=" + id + ", fecha_entrega=" + fecha_entrega + ", fecha_entrega_real="
    //             + fecha_entrega_real + ", fecha_inicio_pedido=" + fecha_inicio_pedido + ", cliente=" + cliente
    //             + ", muebles=" + muebles + "]";
    // }
    

    
    
}
