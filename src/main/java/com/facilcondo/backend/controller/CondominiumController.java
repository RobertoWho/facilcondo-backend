package com.facilcondo.backend.controller;

import com.facilcondo.backend.dto.CondominiumDTO;
import com.facilcondo.backend.service.CondominiumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/condominiums")
public class CondominiumController {

    private final CondominiumService condominiumService;

    public CondominiumController(CondominiumService condominiumService) {
        this.condominiumService = condominiumService;
    }

    @GetMapping
    public List<CondominiumDTO> getAll() {
        return condominiumService.getAll();
    }

    @PostMapping
    public ResponseEntity<CondominiumDTO> create(@Valid @RequestBody CondominiumDTO dto) {
        CondominiumDTO created = condominiumService.create(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }
}
