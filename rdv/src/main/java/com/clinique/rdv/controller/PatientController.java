package com.clinique.rdv.controller;


import com.clinique.rdv.entity.Patient;
import com.clinique.rdv.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping
    public Patient create(@RequestBody Patient p) {
        return service.save(p);
    }

    @GetMapping
    public List<Patient> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Patient getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Patient update(@PathVariable Long id, @RequestBody Patient p) {
        return service.update(id, p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}