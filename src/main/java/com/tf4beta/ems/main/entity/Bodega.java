package com.tf4beta.ems.main.entity;


import javax.persistence.*;

@Entity
@Table (name = "Bodega")
public class Bodega {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "codigo_bodega")
    private int codigo_bodega;

    @Column()


}
