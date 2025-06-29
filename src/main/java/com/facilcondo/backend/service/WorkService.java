package com.facilcondo.backend.service;

import com.facilcondo.backend.model.Work;
import com.facilcondo.backend.repository.WorkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkService {

    private final WorkRepository repository;

    public WorkService(WorkRepository repository) {
        this.repository = repository;
    }

    public List<Work> getAll() {
        return repository.findAll();
    }

    public Work getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Work not found"));
    }

    public Work create(Work work) {
        return repository.save(work);
    }

    public Work update(Long id, Work updated) {
        Work existing = getById(id);
        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setDateTime(updated.getDateTime());
        existing.setCondominium(updated.getCondominium());
        existing.setCreatedBy(updated.getCreatedBy());
        existing.setCost(updated.getCost());
        existing.setStatus(updated.getStatus());
        existing.setNotes(updated.getNotes());
        existing.setAttachments(updated.getAttachments());
        existing.setIsActive(updated.getIsActive());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
