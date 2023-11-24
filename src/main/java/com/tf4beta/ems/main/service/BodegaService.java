package com.tf4beta.ems.main.service;

import com.tf4beta.ems.main.dao.BodegaDao;
import com.tf4beta.ems.main.entity.Bodega;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BodegaService {

    @Autowired
    private BodegaDao bodegaDao;

    public List<Bodega> findAll(){
        return bodegaDao.findAllBodegas();
    }
}
