package com.tf4beta.ems.main.controllers;

import com.tf4beta.ems.main.entity.Articulo;
import com.tf4beta.ems.main.entity.Bodega;
import com.tf4beta.ems.main.entity.Ingreso;
import com.tf4beta.ems.main.entity.IngresoDetalles;
import com.tf4beta.ems.main.service.ArticleService;
import com.tf4beta.ems.main.service.BodegaService;
import com.tf4beta.ems.main.service.IngresoDetalleService;
import com.tf4beta.ems.main.service.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ingresoDetalles")
public class IngresoDetalleController {


    @Autowired
    private IngresoDetalleService ingresoDetalleService;
    @Autowired
    private BodegaService bodegaService;
    @Autowired
    private IngresoService ingresoService;
    @Autowired
    private ArticleService articleService;

    public IngresoDetalleController(IngresoDetalleService ingresoDetalleService) {
        this.ingresoDetalleService = ingresoDetalleService;
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
    public String listaIngresoDetalle(Model model) {
        List<IngresoDetalles> ingresoDetalles = ingresoDetalleService.findAll();
        model.addAttribute("ingresoDetalles", ingresoDetalles);
        return "ingresos/list-ingresoDetalles";

    }

    @RequestMapping("/showIngresoDetallesDetails")
    public String viewIngresoDetalles(@RequestParam("id_ingresos_detalle") Integer id_ingreso_detalle, Model model) {
        IngresoDetalles ingresoDetalles = ingresoDetalleService.findById(id_ingreso_detalle);
        model.addAttribute("ingresoDetalles", ingresoDetalles);
        return "ingresos/ingresosDetalles-view";
    }

    @GetMapping("/showFormForAdd")
    public String showFormFordAdd(Model model) {
        IngresoDetalles ingresoDetalles = new IngresoDetalles();
        Ingreso ingreso = new Ingreso();
        model.addAttribute("ingresos", ingreso);
        model.addAttribute("ingresosDetalles", ingresoDetalles);
        return "ingresos/ingresosDetalles-form";

    }

    @GetMapping("/showFormForUpdate")
    public String showFormFormForUpdate(@RequestParam("id_ingreso_detalle") Integer id_ingreso_detalle, Model model) {
        IngresoDetalles ingresoDetalles = ingresoDetalleService.findById(id_ingreso_detalle);

        //lista ingresos
        List<Ingreso> allIngresos = ingresoService.findAll();
        //lista articulos
        List<Articulo> allArticulos = articleService.findAll();
        model.addAttribute("ingresoDetalles", ingresoDetalles);
        model.addAttribute("allIngresos", allIngresos);
        model.addAttribute("allArticulos", allArticulos);
        return "ingresos/ingresosDetalle-updateForm";

    }

    @PostMapping("/save")
    public String saveIngresosDetalles(@ModelAttribute("ingresoDetalles") IngresoDetalles ingresoDetalles) {

        ingresoDetalleService.save(ingresoDetalles);
        return "redirect:/ingresoDetalles/list";

    }

    @PostMapping("/update")
    public String updateIngresoDetalles(@ModelAttribute("ingresoDetalles") IngresoDetalles ingresoDetalles) {
        ingresoDetalleService.update(ingresoDetalles);
        return "redirect:/ingresoDetalle/list";

    }

    @GetMapping("/delate")
    public String delateIngresoDetalle(@RequestParam("id_ingreso_detalles") Integer id_ingreso_detalles) {

        ingresoDetalleService.deleteBycodigo(id_ingreso_detalles);
        return "redirect:/ingresosDetalles/list";
    }
}







