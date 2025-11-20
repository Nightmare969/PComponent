package PComponent_Eva3.PComponent.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "venta")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "precio", length = 50, nullable = false)
    private Integer precio;
    
    @Column(name = "cantidad", length = 50, nullable = false)
    private Integer cantidad;

    @Column(name = "telefono", length = 150, nullable = false)
    private Integer telefono;

    @Column(name = "correo", length = 150, nullable = false) 
    private String correo;

    
}
