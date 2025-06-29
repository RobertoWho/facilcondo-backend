package com.facilcondo.backend.controller;

import com.facilcondo.backend.model.Apartment;
import com.facilcondo.backend.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apartments")
public class ApartmentController {

    private final ApartmentService service;

    @Autowired
    public ApartmentController(ApartmentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Apartment>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apartment> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Apartment> create(@RequestBody Apartment apartment) {
        return ResponseEntity.ok(service.create(apartment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Apartment> update(@PathVariable Long id, @RequestBody Apartment apartment) {
        return ResponseEntity.ok(service.update(id, apartment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
