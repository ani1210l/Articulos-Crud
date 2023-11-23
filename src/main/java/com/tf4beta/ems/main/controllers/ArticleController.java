package com.tf4beta.ems.main.controllers;

import com.tf4beta.ems.main.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;

public class ArticleController {

    private ArticleService articleService;
    @Autowired
    public  ArticleController(ArticleService articleService){
        this.articleService
    }
}
