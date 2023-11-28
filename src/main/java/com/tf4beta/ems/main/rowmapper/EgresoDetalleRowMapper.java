package com.tf4beta.ems.main.rowmapper;

import com.tf4beta.ems.main.entity.Bodega;
import com.tf4beta.ems.main.entity.Egreso;
import com.tf4beta.ems.main.entity.EgresoDetalles;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EgresoDetalleRowMapper implements RowMapper <EgresoDetalles> {
    @Override
    public EgresoDetalles mapRow(ResultSet rs, int rowNum) throws SQLException {
        EgresoDetalles egr = new EgresoDetalles();
        egr.setId_egreso_detalles(rs.getInt("id_egreso_detalles"));
        egr.setCantidad(rs.getInt("cantidad"));
        egr.setCosto(rs.getDouble("costo"));
        //Egreso
        Egreso egreso = createEgresoFromResultSet((rs));
        egr.setEgreso(egreso);
        return egr;
    }
    public Egreso createEgresoFromResultSet(ResultSet rs) throws SQLException {

        Egreso egreso = new Egreso();
        egreso.setId_egreso_cab(rs.getInt("id_egreso_cab"));
        egreso.setFecha(rs.getString("fecha"));
        //Bodega
        Bodega bodega = createBodegaFromResultSet(rs);
        egreso.setBodega(bodega);

        return egreso;
    }
    private Bodega createBodegaFromResultSet(ResultSet rs) throws SQLException {
        Bodega bodega = new Bodega();
        bodega.setCodigo_bodega(rs.getInt("codigo_bodega"));
        bodega.setNombre(rs.getString("nombre"));
        bodega.setUbicacion(rs.getString("ubicacion"));
        bodega.setCodigoB(rs.getString("codigoB"));

        return bodega;
    }
}
