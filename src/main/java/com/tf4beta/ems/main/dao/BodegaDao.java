package com.tf4beta.ems.main.dao;

import com.tf4beta.ems.main.entity.Bodega;
import com.tf4beta.ems.main.rowmapper.BodegaRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BodegaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Bodega> findAllBodegas(){
        String sql = "SELECT * FROM Bodega";
        return jdbcTemplate.query(sql, new BodegaRowMapper());
    }
}
