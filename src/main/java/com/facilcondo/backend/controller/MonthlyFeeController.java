package com.facilcondo.backend.controller;

import com.facilcondo.backend.model.MonthlyFee;
import com.facilcondo.backend.service.MonthlyFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monthly-fees")
public class MonthlyFeeController {

    private final MonthlyFeeService service;

    @Autowired
    public MonthlyFeeController(MonthlyFeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MonthlyFee>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonthlyFee> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<MonthlyFee> create(@RequestBody MonthlyFee monthlyFee) {
        return ResponseEntity.ok(service.create(monthlyFee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonthlyFee> update(@PathVariable Long id, @RequestBody MonthlyFee monthlyFee) {
        return ResponseEntity.ok(service.update(id, monthlyFee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
