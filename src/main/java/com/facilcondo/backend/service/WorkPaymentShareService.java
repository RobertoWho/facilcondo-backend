package com.facilcondo.backend.service;

import com.facilcondo.backend.advice.exception.NotFoundException;
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
        return repository.findById(id).orElseThrow(() -> new NotFoundException("WorkPaymentShare not found at this ID: " + id));
    }

    public WorkPaymentShare update(Long id, WorkPaymentShare updatedShare) {
        WorkPaymentShare existing = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("WorkPaymentShare not found at this ID: " + id));

        existing.setAmount(updatedShare.getAmount());
        existing.setIsPaid(updatedShare.getIsPaid());
        existing.setNotes(updatedShare.getNotes());

        return repository.save(existing);
    }


    public WorkPaymentShare create(WorkPaymentShare share) {
        return repository.save(share);
    }

    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("WorkPaymentShare not found at this ID: " + id));
        repository.deleteById(id);
    }
}
