package com.facilcondo.backend.controller;

import com.facilcondo.backend.model.WorkPaymentShare;
import com.facilcondo.backend.service.WorkPaymentShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/work-payment-shares")
public class WorkPaymentShareController {

    private final WorkPaymentShareService service;

    @Autowired
    public WorkPaymentShareController(WorkPaymentShareService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<WorkPaymentShare>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkPaymentShare> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<WorkPaymentShare> create(@RequestBody WorkPaymentShare share) {
        return ResponseEntity.ok(service.create(share));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
