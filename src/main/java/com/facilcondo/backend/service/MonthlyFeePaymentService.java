package com.facilcondo.backend.service;

import com.facilcondo.backend.model.MonthlyFeePayment;
import com.facilcondo.backend.repository.MonthlyFeePaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthlyFeePaymentService {

    private final MonthlyFeePaymentRepository repository;

    public MonthlyFeePaymentService(MonthlyFeePaymentRepository repository) {
        this.repository = repository;
    }

    public List<MonthlyFeePayment> getAll() {
        return repository.findAll();
    }

    public MonthlyFeePayment getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("MonthlyFeePayment not found"));
    }

    public MonthlyFeePayment create(MonthlyFeePayment payment) {
        return repository.save(payment);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
