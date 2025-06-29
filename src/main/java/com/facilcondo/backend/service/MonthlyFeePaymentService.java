package com.facilcondo.backend.service;

import com.facilcondo.backend.advice.exception.NotFoundException;
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
        return repository.findById(id).orElseThrow(() -> new NotFoundException("MonthlyFeePayment not found at this ID: " + id));
    }

    public MonthlyFeePayment create(MonthlyFeePayment payment) {
        return repository.save(payment);
    }

    public MonthlyFeePayment update(Long id, MonthlyFeePayment updatedPayment) {
        MonthlyFeePayment existing = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("MonthlyFeePayment not found at this ID: " + id));
        existing.setAmount(updatedPayment.getAmount());
        existing.setIsPaid(updatedPayment.getIsPaid());
        existing.setNotes(updatedPayment.getNotes());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("MonthlyFeePayment not found at this ID: " + id));
        repository.deleteById(id);
    }
}
