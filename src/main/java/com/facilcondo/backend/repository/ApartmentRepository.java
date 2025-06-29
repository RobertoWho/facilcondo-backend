package com.facilcondo.backend.repository;

import com.facilcondo.backend.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    // Query personalizzate future
}
