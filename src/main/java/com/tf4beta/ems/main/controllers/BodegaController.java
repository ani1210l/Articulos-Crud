package com.tf4beta.ems.main.controllers;
import com.tf4beta.ems.main.entity.Bodega;
import com.tf4beta.ems.main.service.BodegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bodegas")
public class BodegaController {

    private BodegaService bodegaService;

    @Autowired
    public BodegaController(BodegaService bodegaService){
        this.bodegaService = bodegaService;
    }


    @GetMapping("index")
    public String bodegaIndex(){
        return "bodegas/bodegas-index.html";
    }

    @GetMapping("/list")
    public String listBodegas(Model theModel){
        List<Bodega> theBodega = bodegaService.findAll();
        theModel.addAttribute("bodega", theBodega);
        return "bodegas/list-bodegas";
    }

    @RequestMapping("/showBodegaDetails")
    public String viewBodega (@RequestParam("bodegaId")  int codigo_bodega, Model model){
        Bodega bodega = bodegaService.findById(codigo_bodega);
        model.addAttribute("bodega",bodega);
        return "bodegas/bodegas-view";
    }
    @GetMapping("/searchName")
    public String searchName(@RequestParam("searchName") String searchName, Model model){
        List<Bodega> bodega = bodegaService.findByNameOrLocate(searchName);
        if (bodega.isEmpty()){
            model.addAttribute("searchWarning","Sorry! We not found that name.");
        }
        model.addAttribute("bodega" ,bodega);
        return "bodegas/list-bodegas";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Bodega bodega = new Bodega();

        theModel.addAttribute("bodega", bodega);

        return "bodegas/bodegas-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bodegaID") int codigoBodega, Model theModel) {

        Bodega bodega = bodegaService.findById(codigoBodega);

        theModel.addAttribute("bodega", bodega);

        return "bodegas/bodegas-updateForm";
    }
    @PostMapping("/save")
    public String saveBodega(@ModelAttribute("bodega") Bodega bodega) {

        bodegaService.save(bodega);

        return "redirect:/bodegas/list";
    }

    @PostMapping("/update")
    public String updateBodega(@ModelAttribute("bodega") Bodega bodega) {

        bodegaService.update(bodega);

        return "redirect:/bodegas/list";
    }

    @GetMapping("/delete")
    public String deleteBodega(@RequestParam("bodegaID") int theId) {

        bodegaService.deleteByCodigoBodega(theId);

        return "redirect:/bodegas/list";
    }

}
