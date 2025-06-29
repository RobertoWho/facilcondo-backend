package com.facilcondo.backend.service;

import com.facilcondo.backend.advice.exception.NotFoundException;
import com.facilcondo.backend.model.Apartment;
import com.facilcondo.backend.repository.ApartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentService {

    private final ApartmentRepository repository;

    public ApartmentService(ApartmentRepository repository) {
        this.repository = repository;
    }

    public List<Apartment> getAll() {
        return repository.findAll();
    }

    public Apartment getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Apartment not found at this ID: " + id));
    }

    public Apartment create(Apartment apartment) {
        return repository.save(apartment);
    }

    public Apartment update(Long id, Apartment updated) {
        Apartment existing = getById(id);
        existing.setNumber(updated.getNumber());
        existing.setFloor(updated.getFloor());
        existing.setBuildingBlock(updated.getBuildingBlock());
        existing.setNotes(updated.getNotes());
        existing.setCondominium(updated.getCondominium());
        existing.setOwner(updated.getOwner());
        existing.setTenant(updated.getTenant());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("Apartment not found at this ID: " + id));
        repository.deleteById(id);
    }
}
