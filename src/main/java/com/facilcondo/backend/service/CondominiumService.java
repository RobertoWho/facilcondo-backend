package com.facilcondo.backend.service;

import com.facilcondo.backend.dto.CondominiumDTO;
import com.facilcondo.backend.model.CondominiumModel;
import com.facilcondo.backend.repository.CondominiumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondominiumService {

    private final CondominiumRepository repository;

    public CondominiumService(CondominiumRepository repository) {
        this.repository = repository;
    }

    public List<CondominiumDTO> getAll() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public CondominiumDTO create(CondominiumDTO dto) {
        CondominiumModel model = toModel(dto);
        CondominiumModel saved = repository.save(model);
        return toDTO(saved);

    }

    private CondominiumDTO toDTO(CondominiumModel model) {
        return CondominiumDTO.builder()
                .name(model.getName())
                .street(model.getStreet())
                .streetNumber(model.getStreetNumber())
                .zipCode(model.getZipCode())
                .city(model.getCity())
                .province(model.getProvince())
                .region(model.getRegion())
                .country(model.getCountry())
                .build();
    }

    private CondominiumModel toModel(CondominiumDTO dto) {
        return CondominiumModel.builder()
                .name(dto.getName())
                .street(dto.getStreet())
                .streetNumber(dto.getStreetNumber())
                .zipCode(dto.getZipCode())
                .city(dto.getCity())
                .province(dto.getProvince())
                .region(dto.getRegion())
                .country(dto.getCountry())
                .build();
    }
}


