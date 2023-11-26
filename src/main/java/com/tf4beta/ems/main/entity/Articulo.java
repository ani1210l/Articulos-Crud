package com.tf4beta.ems.main.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Articulo")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_articulo")
    private int id_articulo;

    @Column(name = "codigoA")
    private String codigoA;

    @Column(name = "nombre_articulo")
    private String nombre_articulo;

    @Column(name = "clasificacion")
    private String clasificacion;

    @Column(name = "stock_minimo")
    private int stock_minimo;

    @Column(name = "stock_maximo")
    private int stock_maximo;

    @Column(name = "stock_actual")
    private int stock_actual;

    @Column(name = "costo_promedio")
    private double costo_promedio;

    @ManyToOne
    @JoinColumn(name = "codigo_bodega")
    private Bodega bodegas;

    public Articulo() {
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getCodigoA() {
        return codigoA;
    }

    public void setCodigoA(String codigoA) {
        this.codigoA = codigoA;
    }

    public String getNombre_articulo() {
        return nombre_articulo;
    }

    public void setNombre_articulo(String nombre_articulo) {
        this.nombre_articulo = nombre_articulo;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(int stock_minimo) {
        this.stock_minimo = stock_minimo;
    }

    public int getStock_maximo() {
        return stock_maximo;
    }

    public void setStock_maximo(int stock_maximo) {
        this.stock_maximo = stock_maximo;
    }

    public int getStock_actual() {
        return stock_actual;
    }

    public void setStock_actual(int stock_actual) {
        this.stock_actual = stock_actual;
    }

    public double getCosto_promedio() {
        return costo_promedio;
    }

    public void setCosto_promedio(double costo_promedio) {
        this.costo_promedio = costo_promedio;
    }

    public Bodega getBodegas() {
        return bodegas;
    }

    public void setBodegas(Bodega bodegas) {
        this.bodegas = bodegas;
    }

    public Articulo(int id_articulo, String codigoA, String nombre_articulo, String clasificacion, int stock_minimo, int stock_maximo, int stock_actual, double costo_promedio, Bodega bodegas) {
        this.id_articulo = id_articulo;
        this.codigoA = codigoA;
        this.nombre_articulo = nombre_articulo;
        this.clasificacion = clasificacion;
        this.stock_minimo = stock_minimo;
        this.stock_maximo = stock_maximo;
        this.stock_actual = stock_actual;
        this.costo_promedio = costo_promedio;
        this.bodegas = bodegas;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id_articulo=" + id_articulo +
                ", codigoA=" + codigoA +
                ", nombre_articulo='" + nombre_articulo + '\'' +
                ", clasificacion='" + clasificacion + '\'' +
                ", stock_minimo=" + stock_minimo +
                ", stock_maximo=" + stock_maximo +
                ", stock_actual=" + stock_actual +
                ", costo_promedio=" + costo_promedio +
                ", bodegas=" + bodegas +
                '}';
    }
}
