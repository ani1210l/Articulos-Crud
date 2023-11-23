package com.tf4beta.ems.main.entity;

import javax.persistence.*;


@Entity
@Table(name = "Articulos")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_articulo")
    private int id_articulo;

    @Column(name = "nombre_articulo")
    private String nombre_articulo;

    @Column(name = "ubicacion")
    private String ubicacion;
    @Column(name = "clasificacion")
    private String categoria_articulo;

    @Column(name = "stock_minimo")
    private String stock_minimo;

    @Column(name = "stock_maximo")
    private String stock_maximo;

    @Column(name = "stock_actual")
    private String stock_actual ;

    public Articulo() {
    }

    public Articulo(int id_articulo, String nombre_articulo, String ubicacion, String categoria_articulo, String stock_minimo, String stock_maximo, String stock_actual) {
        this.id_articulo= id_articulo;
        this.nombre_articulo = nombre_articulo;
        this.ubicacion = ubicacion;
        this.categoria_articulo = categoria_articulo;
        this.stock_minimo = stock_minimo;
        this.stock_minimo = stock_maximo;
        this.stock_actual = stock_actual;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getNombre_articulo() {
        return nombre_articulo;
    }

    public void setNombre_articulo(String nombre_articulo) {
        this.nombre_articulo = nombre_articulo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCategoria_articulo() {
        return categoria_articulo;
    }

    public void setCategoria_articulo(String categoria_articulo) {
        this.categoria_articulo = categoria_articulo;
    }

    public String getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(String stock_minimo) {
        this.stock_minimo = stock_minimo;
    }

    public String getStock_maximo() {
        return stock_maximo;
    }

    public void setStock_maximo(String stock_maximo) {
        this.stock_maximo = stock_maximo;
    }

    public String getStock_actual() {
        return stock_actual;
    }

    public void setStock_actual(String stock_actual) {
        this.stock_actual = stock_actual;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id_articulo=" + id_articulo +
                ", nombre_articulo='" + nombre_articulo + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", categoria_articulo='" + categoria_articulo + '\'' +
                ", stock_minimo='" + stock_minimo + '\'' +
                ", stock_maximo='" + stock_maximo + '\'' +
                ", stock_actual='" + stock_actual + '\'' +
                ",getCodigo_articulo()= " + getId_articulo() +
                ",getnombre_articulo() = " + getNombre_articulo()+
                ",getubicacion() = " + getUbicacion()+
                ",getcategoria_articulo() = " + getCategoria_articulo()+
                "getstockminimo() = " + getStock_minimo()+
                "getstockMaximo() = " +

                '}';
    }

    ///public String toString() {
      //  return "articulo[" +
            ///    "id_articulo=" + id_articulo +
               // ", nombre_articulo='" + nombre_articulo + '\'' +
               // ", descripcion='" + descripcion + '\'' +
             ///   ", categoria_articulo='" + categoria_articulo + '\'' +
             ///   ", precio_articulo='" + precio_articulo + '\'' +
              //  ", proveedor='" + proveedor + '\'' +
             //   ", cantidad='" + cantidad + '\'' +
             //   ",getId_articulo()= " + getId_articulo() +
             ///   ", getNombre_articulo()= " + getNombre_articulo()+
            ///    ", getDescripcion()= " + getDescripcion()+
           ///*     ", getCategoria_articulo() = " +getCategoria_articulo()+
           ////     ", getPrecio_articulo()= " +getPrecio_articulo()+
          ////      ", getProveedor() = " + getProveedor()+
            ////    ",getCantidad() =" + getCantidad()+
             ////   ", getCLass() =" + getClass() +
           ///     ", hashCode()=" + hashCode()+
             ///   ",toString=" + super.toString()+
                ']';
    }
}
