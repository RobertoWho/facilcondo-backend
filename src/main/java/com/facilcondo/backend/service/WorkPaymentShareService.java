package com.facilcondo.backend.service;

import com.facilcondo.backend.model.WorkPaymentShare;
import com.facilcondo.backend.repository.WorkPaymentShareRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkPaymentShareService {

    private final WorkPaymentShareRepository repository;

    public WorkPaymentShareService(WorkPaymentShareRepository repository) {
        this.repository = repository;
    }

    public List<WorkPaymentShare> getAll() {
        return repository.findAll();
    }

    public WorkPaymentShare getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("WorkPaymentShare not found"));
    }

    public WorkPaymentShare create(WorkPaymentShare share) {
        return repository.save(share);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
