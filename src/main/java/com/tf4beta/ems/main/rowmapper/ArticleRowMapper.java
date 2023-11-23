package com.tf4beta.ems.main.rowmapper;

import com.tf4beta.ems.main.entity.Articulo;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper implements RowMapper<Articulo> {



    @Override
    public Articulo mapRow(ResultSet rs, int rowNum) throws SQLException {



        Articulo articulo = new Articulo();
        articulo.setId_articulo(rs.getInt("id_articulo"));
        articulo.setNombre_articulo(rs.getString("nombre_articulo"));
        articulo.setCategoria_articulo(rs.getString("categoria_articulo"));
        articulo.setDescripcion(rs.getString("descripcion"));
        articulo.setPrecio_articulo(rs.getString("precio_articulo"));
        articulo.setProveedor(rs.getString("proveedor"));
        articulo.setCantidad(rs.getString("cantidad"));
        return articulo;
    }

}
