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

@Entity(name = "mueble_has_entrega")
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
    // @EmbeddedId
    // private MuebleEntregasKey id;

    // @ManyToOne
    // @JoinColumn(name = "mueble_id")
    // @MapsId("muebleId")
    // private MuebleEntity mueble;

    // @ManyToOne
    // @JoinColumn(name = "entrega_id")
    // @MapsId("entregaId")
    // private EntregaEntity entrega;

    @Column(name = "cantidad")
    private int cantidad;
    
    // public MuebleEntregasEntity(EntregaEntity entrega, MuebleEntity mueble, Integer cantidad) {
    //     this.entrega = entrega;
    //     this.mueble = mueble;
    //     this.cantidad = cantidad;
    // }


    @Override
    public String toString() {
        return "MuebleEntregasEntity [entrega=" + entrega + ", mueble=" + mueble + ", cantidad=" + cantidad + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((entrega == null) ? 0 : entrega.hashCode());
        result = prime * result + ((mueble == null) ? 0 : mueble.hashCode());
        result = prime * result + cantidad;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MuebleEntregasEntity other = (MuebleEntregasEntity) obj;
        if (entrega == null) {
            if (other.entrega != null)
                return false;
        } else if (!entrega.equals(other.entrega))
            return false;
        if (mueble == null) {
            if (other.mueble != null)
                return false;
        } else if (!mueble.equals(other.mueble))
            return false;
        if (cantidad != other.cantidad)
            return false;
        return true;
    }

   


    
    
}
