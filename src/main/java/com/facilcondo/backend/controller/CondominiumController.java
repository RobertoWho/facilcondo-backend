package com.facilcondo.backend.controller;

import com.facilcondo.backend.model.Condominium;
import com.facilcondo.backend.service.CondominiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/condominiums")
public class CondominiumController {

    private final CondominiumService service;

    @Autowired
    public CondominiumController(CondominiumService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Condominium>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Condominium> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Condominium> create(@RequestBody Condominium condominium) {
        return ResponseEntity.ok(service.create(condominium));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Condominium> update(@PathVariable Long id, @RequestBody Condominium condominium) {
        return ResponseEntity.ok(service.update(id, condominium));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
