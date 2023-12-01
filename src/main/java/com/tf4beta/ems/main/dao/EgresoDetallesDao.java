package com.tf4beta.ems.main.dao;

import com.tf4beta.ems.main.entity.EgresoDetalles;
import com.tf4beta.ems.main.rowmapper.EgresoDetalleRowMapper;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EgresoDetallesDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
//guardar
    public void save(EgresoDetalles egresoDetalles) {
        String sql = "INSERT INTO egreso_detalles (cantidad, costo, id_egreso_cab, codigoa) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                egresoDetalles.getCantidad(),
                egresoDetalles.getCosto(),
                egresoDetalles.getEgreso().getId_egreso_cab(),
                egresoDetalles.getArticulo().getCodigoA()
        );
    }
//borrar por id esta de ber si se borra tambien el de la tabla egresos para que no quede vaciola info en esa tabla
    public void delete(int id_egreso_detalles) {
        String sql = "DELETE FROM egreso_detalles WHERE id_egreso_detalles = ?";
        jdbcTemplate.update(sql, id_egreso_detalles);
    }
    //actualizar
    public void update(EgresoDetalles egresoDetalles) {
        String sql = "UPDATE egreso_detalles SET cantidad = ?, costo = ?, id_egreso_cab = ?, codigoa = ? WHERE id_egreso_detalles = ?";
        jdbcTemplate.update(
                sql,
                egresoDetalles.getCantidad(),
                egresoDetalles.getCosto(),
                egresoDetalles.getEgreso().getId_egreso_cab(),
                egresoDetalles.getArticulo().getCodigoA(),
                egresoDetalles.getId_egreso_detalles()
        );
    }
    //findById de Egresos
    public EgresoDetalles findById(int id_egreso_detalles) {
        String sql = "SELECT * FROM egreso_detalles WHERE id_egreso_detalles = ?";
        return jdbcTemplate.queryForObject(sql, new EgresoDetalleRowMapper(), id_egreso_detalles);
    }
    //findById para mostrar en la pantalla de detalles con todos los datos de todas las tablas
    public EgresoDetalles findByIdWithAllDetails(int id_egreso_detalles) {
        String sql = "SELECT `egreso_detalles`.*, `egreso`.*, `articulo`.*, `bodega`.*\n" +
                "FROM `egreso_detalles`\n" +
                "\tLEFT JOIN `egreso` ON `egreso_detalles`.`id_egreso_cab` = `egreso`.`id_egreso_cab`\n" +
                "\tLEFT JOIN `articulo` ON `egreso_detalles`.`codigoa` = `articulo`.`id_articulo`\n" +
                "\tLEFT JOIN `bodega` ON `articulo`.`codigo_bodega` = `bodega`.`codigo_bodega`\n" +
                "WHERE `egreso_detalles`.`id_egreso_detalles` = ?";
        return jdbcTemplate.queryForObject(sql, new EgresoDetalleRowMapper(), id_egreso_detalles);
    }
//meeh
    public List<EgresoDetalles> findAll() {
        String sql = "SELECT * FROM egreso_detalles";
        return jdbcTemplate.query(sql, new EgresoDetalleRowMapper());
    }
//este es para el listado
    public List<EgresoDetalles> findAllWithAllDetails(){
        String sql = "SELECT `egreso_detalles`.*, `egreso`.*, `articulo`.*, `bodega`.*\n" +
                "FROM `egreso_detalles` \n" +
                "\tLEFT JOIN `egreso` ON `egreso_detalles`.`id_egreso_cab` = `egreso`.`id_egreso_cab` \n" +
                "\tLEFT JOIN `articulo` ON `egreso_detalles`.`codigoa` = `articulo`.`id_articulo` \n" +
                "\tLEFT JOIN `bodega` ON `articulo`.`codigo_bodega` = `bodega`.`codigo_bodega`";
        return jdbcTemplate.query(sql, new EgresoDetalleRowMapper());
    }
    // Método para eliminar un registro en la tabla egreso_detalles y también en la tabla egreso
    public void deleteEgresoDetallesAndEgreso(int id_egreso_detalles) {
        String deleteEgresoSql = "DELETE FROM egreso WHERE id_egreso_cab = (SELECT id_egreso_cab FROM egreso_detalles WHERE id_egreso_detalles = ?)";
        String deleteEgresoDetallesSql = "DELETE FROM egreso_detalles WHERE id_egreso_detalles = ?";


        try {
            // Eliminar el registro en la tabla egreso_detalles
            jdbcTemplate.update(deleteEgresoDetallesSql, id_egreso_detalles);
            // Eliminar el registro correspondiente en la tabla egreso
            jdbcTemplate.update(deleteEgresoSql, id_egreso_detalles);
        } catch (DataAccessException e) {
            // Manejar excepciones de acceso a datos (por ejemplo, errores de SQL)
            throw new RuntimeException("Error al eliminar el registro", e);
        }
    }
}