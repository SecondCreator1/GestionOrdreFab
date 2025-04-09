package tn.itbs.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.itbs.project.model.OrdreFabrication;
import tn.itbs.project.services.OrdreFabricationService;

@RestController
@RequestMapping("/api/ordres")
public class OrdreFabricationController {
	
	@Autowired
    private OrdreFabricationService ordreFabricationService;

    @GetMapping
    public List<OrdreFabrication> getAllOrdres() {
        return ordreFabricationService.getAllOrdres();
    }

    @PostMapping
    public OrdreFabrication createOrdre(@RequestBody OrdreFabrication ordre) {
        return ordreFabricationService.createOrdre(ordre);
    }

    @GetMapping("/{id}")
    public OrdreFabrication getOrdreById(@PathVariable Long id) {
        return ordreFabricationService.getOrdreById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrdre(@PathVariable Long id) {
        ordreFabricationService.deleteOrdre(id);
    }

}
