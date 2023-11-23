package com.tf4beta.ems.main.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "Bodega")
public class Bodega {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "codigo_bodega")
    private int codigo_bodega;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ubicacion")
    private String ubicacion;


    @Override
    public String toString() {
        return "Bodega{" +
                "codigo_bodega=" + codigo_bodega +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
