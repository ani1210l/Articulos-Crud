package com.tf4beta.ems.main.dao;


import com.tf4beta.ems.main.entity.Articulo;
import com.tf4beta.ems.main.rowmapper.ArticleRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save (Articulo articulo){
        String sql = "INSERT INTO articulo (nombre_articulo, ubicacion, categoria_articulo, stock_maximo, stock_minimo, stock_actual, codigo_bodega) Values (?, ?, ?, ?, ?, ?, ?) ";

        jdbcTemplate.update(sql, articulo.getNombre_articulo(), articulo.getUbicacion(), articulo.getCategoria_articulo(), articulo.getStock_maximo(), articulo.getStock_minimo(), articulo.getStock_actual(), articulo.getBodegas().getCodigo_bodega());

    }

public void delate(int id_articulo){
        String sql = "DELATE FROM articulo WHERE id = " + id_articulo;

        jdbcTemplate.update(sql);

}

public void update (Articulo articulo) {
    String sql = "UPDATE articulo SET  nombre_articulo = ? , ubicacion = ?, categoria_articulo = ?, stock_maximo = ?, stock_minimo = ?, stock_actual = ?, codigo_bodega = ?";
    jdbcTemplate.update(sql, articulo.getNombre_articulo(), articulo.getUbicacion(), articulo.getCategoria_articulo(), articulo.getStock_maximo(), articulo.getStock_minimo(), articulo.getStock_actual(), articulo.getBodegas().getCodigo_bodega());

}

    public Articulo findById(int id_articulo){
        String sql = "SELECT * FROM articulo WHERE id_articulo = ?";
        return jdbcTemplate.queryForObject(sql, new ArticleRowMapper(),id_articulo);

    }

    public List <Articulo> findAll(){
        String sql = "SELECT FROM articulo";
        return jdbcTemplate.query(sql, new ArticleRowMapper());
    }
    public List<Articulo>searchByName(String searchName){
        String sql = "SELECT * FROM articulo WHERE nombre_articulo LIKE '%" + searchName + "%' OR descripcion LIKE '%" +searchName + "% '";
        return jdbcTemplate.query(sql, new ArticleRowMapper());
    }

}
