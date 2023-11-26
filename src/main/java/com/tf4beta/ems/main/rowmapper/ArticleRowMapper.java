package com.tf4beta.ems.main.rowmapper;

import com.tf4beta.ems.main.entity.Articulo;
import com.tf4beta.ems.main.entity.Bodega;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper implements RowMapper<Articulo> {



    @Override
    public Articulo mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub

        Articulo articulo = new Articulo();
        articulo.setId_articulo(rs.getInt("id_articulo"));
        articulo.setCodigoA(rs.getString("codigoa"));
        articulo.setNombre_articulo(rs.getString("nombre_articulo"));
        articulo.setClasificacion(rs.getString("clasificacion"));
        articulo.setStock_actual(rs.getInt("stock_actual"));
        articulo.setStock_minimo(rs.getInt("stock_minimo"));
        articulo.setStock_maximo(rs.getInt("stock_maximo"));
        articulo.setCosto_promedio(rs.getDouble("costo_promedio"));
        // Crear una instancia de Bodega y establecer sus propiedades
        Bodega bodega = new Bodega();
        bodega.setCodigo_bodega(rs.getInt("codigo_bodega"));
        bodega.setNombre(rs.getString("nombre"));
        bodega.setUbicacion(rs.getString("ubicacion"));
        bodega.setCodigoB(rs.getString("codigoB"));

        // Establecer la instancia de Bodega en el artículo
        articulo.setBodegas(bodega);

        return articulo;
    }


}
