package com.tf4beta.ems.main.dao;


import com.tf4beta.ems.main.entity.Ingreso;
import com.tf4beta.ems.main.rowmapper.IngresoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class IngresoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void save (Ingreso ingreso){
        String sql = "INSERT INTO ingreso (fecha, codigo_bodega) VALUES (?,?)":
        JdbcTemplate.update
                (sql,
                        ingreso.getFecha(),
                        ingreso.getBodega().getCodigo_bodega()
                );
    }
    public Ingreso findById(int id_ingresocab){
        String sql = "SELECT i.*, b.codigoB FROM ingreso i LEFT JOIN bodeg b ON a.codigo_bodega = b.codigo_bodega WHERE id_ingresocab = ?";
        return jdbcTemplate.queryForObject(sql, new IngresoRowMapper(), id_ingresocab);
    }
    public  Ingreso findAllDetails(Integer id_ingresocab){
        String sql = "SELECT i.*, b.codigoB FROM ingreso i LEFT JOIN bodeg b ON a.codigo_bodega = b.codigo_bodega WHERE id_ingresocab = ?";
return jdbcTemplate.queryForObject(sql, new IngresoRowMapper(),id_ingresocab);

    }
    ///public List<Ingreso>findAll(){
        ////String sql = "SELECT * FROM ingreso LEFT JOIN bodega ON ingreso.codigo_bodega= bodega.codigoBodega";
        ////return jdbcTemplate.queryForObject(sql.new IngresoRowMapper());
    }
}
