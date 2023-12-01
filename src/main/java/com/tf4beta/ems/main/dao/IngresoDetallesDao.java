package com.tf4beta.ems.main.dao;


import com.tf4beta.ems.main.entity.IngresoDetalles;
import com.tf4beta.ems.main.rowmapper.IngresoDetalleRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class IngresoDetallesDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    ////Guardar
    public void save(IngresoDetalles ingresoDetalles) {
        String sql = "INSERT INTO ingresoDetalles(id_ingresos_detalle, cantidad_ingresada, precio_compra, id_articulo, id_ingresoss_cab)VALUES(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                ingresoDetalles.getId_Ingresos_detalle(),
                ingresoDetalles.getCantidad_ingresada(),
                ingresoDetalles.getPrecio_compra(),
                ingresoDetalles.getArticulo().getCodigoA(),
                ingresoDetalles.getIngreso().getId_ingresocab()
        );
    }
    ////Borrar por id

    public void delate(int id_ingdetalle) {
        String sql = "DELATE FROM ingresoDetalles WHERE id_ingdetalle = ?";
        jdbcTemplate.update(sql, id_ingdetalle);

    }

    ////Actualizar
    public void update(IngresoDetalles ingresoDetalles) {
        String sql = "UPDATE ingresoDetalles SET  id_ingresos_detalle = ?, cantidad_ingresada = ?, precio_compra = ?, id_articulo = ?, id_ingresoss_cab = ? WHERE id_ingdetalle = ?";
        jdbcTemplate.update(
                sql,
                ingresoDetalles.getId_Ingresos_detalle(),
                ingresoDetalles.getCantidad_ingresada(),
                ingresoDetalles.getPrecio_compra(),
                ingresoDetalles.getArticulo().getCodigoA(),
                ingresoDetalles.getIngreso().getId_ingresocab()
        );


    }

    public IngresoDetalles findById(int id_ingdetalle) {
        String sql = "SELECT * FROM ingresoDetalles WHERE id_ingresos_detalle = ?";
        return jdbcTemplate.queryForObject(sql, new IngresoDetalleRowMapper(), id_ingdetalle);
    }

    public List<IngresoDetalles> findAll() {
        String sql = "SELECT * FROM ingresoDetalles";
        return jdbcTemplate.query(sql, new IngresoDetalleRowMapper());
    }

    public List<IngresoDetalles> findAllWithAllDetails() {
        String sql = "SELECT ` ingresoDetalles`.*, `ingreso`.*, `articulo`.*, `bodega`.*\n" +
                "FROM `ingresoDetalles `\n" +
                "\tLEFT JOIN `ingreso` ON ` ingresoDetalles` . `id_ingresoss_cab` = `ingreso`.`id_ingresoss_cab` \n" +
                "\tLEFT JOIN `articulo` ON  `ingresoDetalles`. `codigoa` = `articulo`.`id_articulo`\n" +
                "\tLEFT JOIN  `bodega` ON `articulo`.`codigo_bodega` = `bodega`.`codigo_bodega`";
         return jdbcTemplate.query(sql, new IngresoDetalleRowMapper());
    }


}