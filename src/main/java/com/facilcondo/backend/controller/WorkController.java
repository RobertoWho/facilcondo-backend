package com.facilcondo.backend.controller;

import com.facilcondo.backend.model.Work;
import com.facilcondo.backend.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/works")
public class WorkController {

    private final WorkService service;

    @Autowired
    public WorkController(WorkService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Work>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Work> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Work> create(@RequestBody Work work) {
        return ResponseEntity.ok(service.create(work));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Work> update(@PathVariable Long id, @RequestBody Work work) {
        return ResponseEntity.ok(service.update(id, work));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
