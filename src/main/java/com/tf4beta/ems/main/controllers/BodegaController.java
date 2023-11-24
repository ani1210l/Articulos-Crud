package com.tf4beta.ems.main.controllers;

import com.tf4beta.ems.main.entity.Bodega;
import com.tf4beta.ems.main.service.BodegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bodegas")
public class BodegaController {

    private BodegaService bodegaService;

    @Autowired
    public BodegaController(BodegaService bodegaService){
        this.bodegaService = bodegaService;
    }

    @GetMapping("/list")
    public String listBodegas(Model theModel){
        List<Bodega> theBodega = bodegaService.findAll();
        theModel.addAttribute("Bodega", theBodega);
        return "bodegas/list-bodegas";
    }
}
