package com.tf4beta.ems.main.controllers;

import com.tf4beta.ems.main.dao.EgresoDao;
import com.tf4beta.ems.main.entity.Articulo;
import com.tf4beta.ems.main.entity.Bodega;
import com.tf4beta.ems.main.entity.Egreso;
import com.tf4beta.ems.main.entity.EgresoDetalles;
import com.tf4beta.ems.main.service.BodegaService;
import com.tf4beta.ems.main.service.EgresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    public EgresoController (EgresoService egresoService){
        this.egresoService = egresoService;
    }


    @GetMapping("/list")
    public String listEgresosBodega(Model theModel) {
        List<Egreso> egresos = egresoService.findAll();
        theModel.addAttribute("egresos", egresos);
        return "egresos/list-egresos";
    }
    @PostMapping("/save")
    public String saveEgreso(@ModelAttribute("egresos") Egreso egreso) {

        egresoService.save(egreso);

        return "redirect:/egresosDetalles/list";
    }

    @PostMapping("/update")
    public String updateEgreso(@ModelAttribute("egreso") Egreso egreso) {

        egresoService.update(egreso);

        return "";

    }

    @GetMapping("/delete")
    public String deleteEgreso(@RequestParam("id_egreso_cab") Integer id_egreso_cab) {

        egresoService.delateByCodigo(id_egreso_cab);

        return "";

    }



}
