package com.tf4beta.ems.main.rowmapper;

import com.tf4beta.ems.main.entity.Articulo;
import com.tf4beta.ems.main.entity.Bodega;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper implements RowMapper<Articulo> {



    @Override
    public Articulo mapRow(ResultSet rs, int rowNum) throws SQLException {

        Articulo articulo = new Articulo();
        articulo.setId_articulo(rs.getInt("id_articulo"));
        articulo.setNombre_articulo(rs.getString("nombre_articulo"));
        articulo.setUbicacion(rs.getString("ubicacion"));
        articulo.setCategoria_articulo(rs.getString("categoria_articulo"));
        articulo.setStock_maximo(rs.getString("stock_maximo"));
        articulo.setStock_minimo(rs.getString("stock_minimo"));
        articulo.setStock_actual(rs.getString("stock_actual"));
        return articulo;
    }


}
