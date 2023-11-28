package com.tf4beta.ems.main.entity;


import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import org.springframework.data.relational.core.sql.In;
import java.util.Date;

import javax.lang.model.element.Name;
import javax.persistence.*;

@Entity
@Table(name = "Ingresos_cab")
public class ingresos_cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingresocab")
    private Integer id_ingresocab;


    @Column(name = "fecha")
    private String fecha;


    @ManyToOne
    @JoinColumn(name = "codigo_bodega")
    private Bodega bodega;

    public ingresos_cab() {
    }

    public ingresos_cab(Integer id_ingresocab, String fecha, Bodega bodega) {
        this.id_ingresocab = id_ingresocab;
        this.fecha = fecha;
        this.bodega = bodega;
    }

    public String toString(){
        return "Ingreso_cab{"+
                "id_ingresocab=" + id_ingresocab +
                " ,fecha= '" + fecha + '\'' +
                ",bodega=" + bodega +
                '}';

    }

    public Integer getId_ingresocab() {
        return id_ingresocab;
    }

    public void setId_ingresocab(Integer id_ingresocab) {
        this.id_ingresocab = id_ingresocab;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
}
