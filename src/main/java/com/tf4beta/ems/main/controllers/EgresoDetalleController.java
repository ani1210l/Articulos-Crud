package com.tf4beta.ems.main.controllers;

import com.tf4beta.ems.main.entity.Articulo;
import com.tf4beta.ems.main.entity.Bodega;
import com.tf4beta.ems.main.entity.Egreso;
import com.tf4beta.ems.main.entity.EgresoDetalles;
import com.tf4beta.ems.main.service.ArticleService;
import com.tf4beta.ems.main.service.BodegaService;
import com.tf4beta.ems.main.service.EgresoDetalleService;
import com.tf4beta.ems.main.service.EgresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/egresosDetalles")
public class EgresoDetalleController {

    @Autowired
    private EgresoDetalleService egresoDetalleService;
    @Autowired
    private BodegaService bodegaService;
    @Autowired
    private EgresoService egresoService;
    @Autowired
    private ArticleService articleService;


    public EgresoDetalleController(EgresoDetalleService egresoDetalleService) {
        this.egresoDetalleService = egresoDetalleService;
    }

    @ModelAttribute("allBodegas")
    public List<Bodega> populateBodegas() {
        return bodegaService.findAll();
    }

    @ModelAttribute("allArticulos")
    public List<Articulo> populateArticulos() {
        return articleService.findAll();
    }

    @GetMapping("/list")
    public String listaEgresosDetalles(Model model) {
        List<EgresoDetalles> egresoDetalles = egresoDetalleService.findAll();
        model.addAttribute("egresosDetalles", egresoDetalles);
        return "egresos/list-egresosDetalles";
    }

    @RequestMapping("/showEgresoDetallesDetails")
    public String viewEgresosDetalles(@RequestParam("id_egreso_detalles") Integer id_egreso_detalles, Model model) {
        EgresoDetalles egresoDetalles = egresoDetalleService.findById(id_egreso_detalles);
        model.addAttribute("egresosDetalles", egresoDetalles);
        return "egresos/egresosDetalles-view";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        EgresoDetalles egresoDetalles = new EgresoDetalles();
        Egreso egreso = new Egreso();
        model.addAttribute("egresos", egreso);
        model.addAttribute("egresosDetalles", egresoDetalles);
        return "egresos/egresosDetalles-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id_egreso_detalles") Integer id_egreso_detalles, Model model) {
        EgresoDetalles egresoDetalles = egresoDetalleService.findById(id_egreso_detalles);
        //lista egreso
        List<Egreso> allEgresos = egresoService.findAll();
        //lista Articulos
        List<Articulo> allArticulos = articleService.findAll();
        model.addAttribute("egresosDetalles", egresoDetalles);
        model.addAttribute("allEgresos", allEgresos);
        model.addAttribute("allArticulos", allArticulos);
        return "egresos/egresosDetalles-updateForm";
    }

    @PostMapping("/save")
    public String saveEgresoDetalles(@ModelAttribute("egresoDetalels") EgresoDetalles egresoDetalles) {

        egresoDetalleService.save(egresoDetalles);

        return "redirect:/egresosDetalles/list";
    }

    @PostMapping("/update")
    public String updateEgresosDetalles(@ModelAttribute("egresoDetalels") EgresoDetalles egresoDetalles) {

        egresoDetalleService.update(egresoDetalles);

        return "redirect:/egresosDetalles/list";

    }

    @GetMapping("/delete")
    public String deleteEgresosDetalles(@RequestParam("id_egreso_detalles") Integer id_egreso_detalles) {

        egresoDetalleService.deleteByCodigo(id_egreso_detalles);

        return "redirect:/egresosDetalles/list";

    }

}
