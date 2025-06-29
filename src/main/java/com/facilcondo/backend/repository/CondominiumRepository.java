package com.facilcondo.backend.repository;

import com.facilcondo.backend.model.Condominium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondominiumRepository extends JpaRepository<Condominium, Long> {
    // Query personalizzate future
}
