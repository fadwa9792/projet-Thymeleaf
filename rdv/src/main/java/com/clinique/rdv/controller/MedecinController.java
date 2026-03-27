package com.clinique.rdv.controller;

import com.clinique.rdv.entity.Medecin;
import com.clinique.rdv.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medecins")
public class MedecinController {

    @Autowired
    private MedecinService service;

    @PostMapping
    public Medecin create(@RequestBody Medecin m) {
        return service.save(m);
    }

    @GetMapping
    public List<Medecin> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Medecin getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Medecin update(@PathVariable Long id, @RequestBody Medecin m) {
        return service.update(id, m);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}