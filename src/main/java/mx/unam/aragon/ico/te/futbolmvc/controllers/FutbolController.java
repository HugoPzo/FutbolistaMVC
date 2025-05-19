package mx.unam.aragon.ico.te.futbolmvc.controllers;

import mx.unam.aragon.ico.te.futbolmvc.models.Futbolista;
import mx.unam.aragon.ico.te.futbolmvc.repositories.FutbolistaRepository;
import mx.unam.aragon.ico.te.futbolmvc.services.FutbolistaService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/futbol")
public class FutbolController {

    private final FutbolistaService futbolistaService;
    private final FutbolistaRepository futbolistaRepository;

    public FutbolController(FutbolistaService futbolistaService, FutbolistaRepository futbolistaRepository) {
        this.futbolistaService = futbolistaService;
        this.futbolistaRepository = futbolistaRepository;
    }

    @GetMapping
    public String futbol() {
        return "futbol";
    }

    @GetMapping("/futbolistas")
    public String futbolista(Model model) {
        List<Futbolista> futbolistas = futbolistaRepository.findAll();
        model.addAttribute("futbolistas", futbolistas);
        return "futbolistas";
    }


    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("futbolista", new Futbolista());
        return "formFutbolista";
    }


    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute Futbolista futbolista
    ){ // Bitacora
        LoggerFactory.getLogger(getClass()).info("Guardando artista " + futbolista);
        // Mandarlo a la BD
        futbolistaService.guardarFutbolista(futbolista);
        return "redirect:/futbol/futbolistas?exito=true";
    }

    @GetMapping("/futbolista/{id}")
    public String futbolista(@PathVariable Integer id, Model model){
        model.addAttribute("futbolista", futbolistaService.getFutbolista(id));
        return "futbolista";
    }



}
