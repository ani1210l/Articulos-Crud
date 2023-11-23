package com.tf4beta.ems.main.service;

import com.tf4beta.ems.main.dao.ArticleDao;
import com.tf4beta.ems.main.entity.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;


    public List <Articulo> findAll(){
        return articleDao.findAll();

    }
    public Articulo findById (int theId){
        Articulo articulo = articleDao.findById(theId);
        return articulo;

    }
    public void save (Articulo theArticulo){
        articleDao.save(theArticulo);

    }
    public void update(Articulo theArticulo){
        articleDao.update(theArticulo);

    }
    public void delateById(int theId){
        articleDao.delate(theId);
    }

    public List <Articulo> searchByName(String searchName){
        List <Articulo> foundArticles = articleDao.searchByName(searchName);
        return foundArticles;
    }
}
