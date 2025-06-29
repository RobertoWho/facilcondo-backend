package com.facilcondo.backend.controller;

import com.facilcondo.backend.model.MonthlyFeePayment;
import com.facilcondo.backend.service.MonthlyFeePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monthly-fee-payments")
public class MonthlyFeePaymentController {

    private final MonthlyFeePaymentService service;

    @Autowired
    public MonthlyFeePaymentController(MonthlyFeePaymentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MonthlyFeePayment>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonthlyFeePayment> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<MonthlyFeePayment> create(@RequestBody MonthlyFeePayment payment) {
        return ResponseEntity.ok(service.create(payment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
