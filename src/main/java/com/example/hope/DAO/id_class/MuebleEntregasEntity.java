package com.example.hope.DAO.id_class;

import com.example.hope.DAO.Entity.EntregaEntity;
import com.example.hope.DAO.Entity.MuebleEntity;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.IdClass;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@IdClass(MuebleEntregaKey.class)
@NoArgsConstructor
@Table(name = "mueble_has_entrega", schema = "hope")
public class MuebleEntregasEntity {
    
    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EntregaEntity entrega;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MuebleEntity mueble;

    @Column(name = "cantidad")
    private Integer cantidad;

    
    public MuebleEntregasEntity(EntregaEntity entrega, MuebleEntity mueble, Integer cantidad) {
        this.entrega = entrega;
        this.mueble = mueble;
        this.cantidad = cantidad;
    }


    @Override
    public String toString() {
        return "MuebleEntregasEntity [entrega=" + entrega + ", mueble=" + mueble + ", cantidad=" + cantidad + "]";
    }
    
    
}
