// package com.example.hope.DAO.id_class;

// import java.io.Serializable;

// import jakarta.persistence.Column;
// import jakarta.persistence.Embeddable;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @Getter
// @Setter
// @Embeddable
// public class MuebleEntregasKey implements Serializable{

//     @Column(name = "mueble_id")
//     private Long muebleId;

//     @Column(name = "entrega_id")
//     private Long entregaId;

//     @Override
//     public int hashCode() {
//         final int prime = 31;
//         int result = 1;
//         result = prime * result + ((muebleId == null) ? 0 : muebleId.hashCode());
//         result = prime * result + ((entregaId == null) ? 0 : entregaId.hashCode());
//         return result;
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj)
//             return true;
//         if (obj == null)
//             return false;
//         if (getClass() != obj.getClass())
//             return false;
//         MuebleEntregasKey other = (MuebleEntregasKey) obj;
//         if (muebleId == null) {
//             if (other.muebleId != null)
//                 return false;
//         } else if (!muebleId.equals(other.muebleId))
//             return false;
//         if (entregaId == null) {
//             if (other.entregaId != null)
//                 return false;
//         } else if (!entregaId.equals(other.entregaId))
//             return false;
//         return true;
//     }

//     @Override
//     public String toString() {
//         return "MuebleEntregasKey [mueble_id=" + muebleId + ", entrega_id=" + entregaId + "]";
//     }
    
    
    
// }
