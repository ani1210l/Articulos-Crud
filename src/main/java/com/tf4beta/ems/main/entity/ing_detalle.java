package com.tf4beta.ems.main.entity;


import javax.persistence.*;

@Entity
@Table(name = "ing_detalle")
public class ing_detalle {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_ingdetalle")
    private  Integer id_ingdetalle;


}
