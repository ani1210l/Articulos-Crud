package com.tf4beta.ems.main.controllers;

import com.tf4beta.ems.main.entity.Articulo;
import com.tf4beta.ems.main.entity.Bodega;
import com.tf4beta.ems.main.entity.Egreso;
import com.tf4beta.ems.main.service.BodegaService;
import com.tf4beta.ems.main.service.EgresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/egresos")
public class EgresoController {

    @Autowired
    private EgresoService egresoService;
    @Autowired
    private BodegaService bodegaService;

    @ModelAttribute("allBodegas")
    public List<Bodega> populateBodegas() {
        return bodegaService.findAll();
    }


    @GetMapping("/list")
    public String listEgresosBodega(Model theModel) {
        List<Egreso> egresos = egresoService.findAll();
        theModel.addAttribute("egresos", egresos);
        return "egresos/list-egresos";
    }



}
