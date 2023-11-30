package com.tf4beta.ems.main.controllers;


import com.tf4beta.ems.main.entity.Bodega;
import com.tf4beta.ems.main.entity.Ingreso;
import com.tf4beta.ems.main.service.BodegaService;
import com.tf4beta.ems.main.service.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ingresos")
public class IngresoController {

    @Autowired
    private IngresoService ingresoService;
    @Autowired
    private BodegaService bodegaService;

    @ModelAttribute("/allBodegas")
    public List<Bodega>populateBodega(){
        return bodegaService.findAll();

    }
    @GetMapping("/list")
    public String listIngresoBodega(Model theModel){
        List<Ingreso>ingresos = ingresoService.findAll();
        theModel.addAttribute("ingresos", ingresos);
        return "ingreso/list-ingresos";
    }


}
