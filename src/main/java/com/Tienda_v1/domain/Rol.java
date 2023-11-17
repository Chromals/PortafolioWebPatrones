package com.Tienda_v1.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="rol")

//Serialización funciona par aalmacenar ciertos datos en la RAM
public class Rol implements Serializable{
   
    private static final long serialVersionUID = 1L; //Para poder hacer el ciclo de la sumatoria del IdRol
    
    @Id // Es la PK de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Los valores generados que tipo de estrategia utilizan BD == Clase
    @Column(name = "id_rol")//Idemtifica la columna para encontrar la tabla
    private long idRol;
    private String nombre;
    @Column(name = "id_usuario")
    private String idUsuario;

    
    @ManyToOne
    @JoinColumn(name="id_usuario")
    List<Usuario> usuarios;

    
}
