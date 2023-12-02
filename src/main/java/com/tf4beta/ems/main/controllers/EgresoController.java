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

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        EgresoDetalles egresoDetalles = new EgresoDetalles();
        Egreso egreso = new Egreso();
        model.addAttribute("egresos", egreso);
        return "egresos/egresos-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id_egreso_cab") Integer id_egreso_cab, Model model) {
        Egreso egreso = egresoService.findById(id_egreso_cab);

        // Obtener la lista de todas las bodegas
        List<Bodega> allBodegas = bodegaService.findAll();
        model.addAttribute("egresos", egreso);
        model.addAttribute("allBodegas", allBodegas);


        return "egresos/egresos-updateForm";
    }


    @PostMapping("/save")
    public String saveEgreso(@ModelAttribute("egresos") Egreso egreso) {

        egresoService.save(egreso);

        return "redirect:/egresosDetalles/showFormForAdd";
    }

    @PostMapping("/update")
    public String updateEgreso(@ModelAttribute("egreso") Egreso egreso) {

        egresoService.update(egreso);

        return "redirect:/egresosDetalles/showFormForUpdate";

    }

    @GetMapping("/delete")
    public String deleteEgreso(@RequestParam("id_egreso_cab") Integer id_egreso_cab) {

        egresoService.delateByCodigo(id_egreso_cab);

        return "redirect:/egresosDetalles/list";

    }



}
