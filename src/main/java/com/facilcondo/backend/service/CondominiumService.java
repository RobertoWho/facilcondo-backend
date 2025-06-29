package com.facilcondo.backend.service;

import com.facilcondo.backend.advice.exception.NotFoundException;
import com.facilcondo.backend.model.Condominium;
import com.facilcondo.backend.repository.CondominiumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondominiumService {

    private final CondominiumRepository repository;

    public CondominiumService(CondominiumRepository repository) {
        this.repository = repository;
    }

    public List<Condominium> getAll() {
        return repository.findAll();
    }

    public Condominium getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Condominium not found at this ID: " + id));
    }

    public Condominium create(Condominium condominium) {
        return repository.save(condominium);
    }

    public Condominium update(Long id, Condominium updated) {
        Condominium existing = getById(id);
        existing.setName(updated.getName());
        existing.setStreet(updated.getStreet());
        existing.setStreetNumber(updated.getStreetNumber());
        existing.setZipCode(updated.getZipCode());
        existing.setCity(updated.getCity());
        existing.setProvince(updated.getProvince());
        existing.setRegion(updated.getRegion());
        existing.setCountry(updated.getCountry());
        existing.setAdministrator(updated.getAdministrator());
        existing.setNotes(updated.getNotes());
        existing.setIsActive(updated.getIsActive());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("Condominium not found at this ID: " + id));
        repository.deleteById(id);
    }
}
