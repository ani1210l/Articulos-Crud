package com.tf4beta.ems.main.entity;

import javax.persistence.*;
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

    public Bodega(int codigo_bodega, String nombre, String ubicacion) {
        super();
        this.codigo_bodega = codigo_bodega;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public Bodega() {
    }

    @Override
    public String toString() {
        return "Bodega{" +
                "codigo_bodega=" + codigo_bodega +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }

    public int getCodigo_bodega() {
        return codigo_bodega;
    }

    public void setCodigo_bodega(int codigo_bodega) {
        this.codigo_bodega = codigo_bodega;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
