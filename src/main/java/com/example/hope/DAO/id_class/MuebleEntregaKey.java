package com.example.hope.DAO.id_class;

import java.io.Serializable;

import com.example.hope.DAO.Entity.EntregaEntity;
import com.example.hope.DAO.Entity.MuebleEntity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MuebleEntregaKey implements Serializable{

    private MuebleEntity mueble;

    private EntregaEntity entrega;

    public MuebleEntregaKey(MuebleEntity mueble, EntregaEntity entrega) {
        this.mueble = mueble;
        this.entrega = entrega;
    }
    

    @Override
    public String toString() {
        return "MuebleEntregaKey [mueble=" + mueble + ", entrega=" + entrega + "]";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mueble == null) ? 0 : mueble.hashCode());
        result = prime * result + ((entrega == null) ? 0 : entrega.hashCode());
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
        MuebleEntregaKey other = (MuebleEntregaKey) obj;
        if (mueble == null) {
            if (other.mueble != null)
                return false;
        } else if (!mueble.equals(other.mueble))
            return false;
        if (entrega == null) {
            if (other.entrega != null)
                return false;
        } else if (!entrega.equals(other.entrega))
            return false;
        return true;
    }

    
    
}
