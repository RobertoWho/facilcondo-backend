package com.facilcondo.backend.service;

import com.facilcondo.backend.model.MonthlyFee;
import com.facilcondo.backend.repository.MonthlyFeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthlyFeeService {

    private final MonthlyFeeRepository repository;

    public MonthlyFeeService(MonthlyFeeRepository repository) {
        this.repository = repository;
    }

    public List<MonthlyFee> getAll() {
        return repository.findAll();
    }

    public MonthlyFee getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("MonthlyFee not found"));
    }

    public MonthlyFee create(MonthlyFee monthlyFee) {
        return repository.save(monthlyFee);
    }

    public MonthlyFee update(Long id, MonthlyFee updated) {
        MonthlyFee existing = getById(id);
        existing.setCondominium(updated.getCondominium());
        existing.setMonth(updated.getMonth());
        existing.setTotalAmount(updated.getTotalAmount());
        existing.setDescription(updated.getDescription());
        existing.setIsActive(updated.getIsActive());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
