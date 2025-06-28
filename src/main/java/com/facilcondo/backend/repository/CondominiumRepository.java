package com.facilcondo.backend.repository;

import com.facilcondo.backend.model.CondominiumModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondominiumRepository extends JpaRepository<CondominiumModel, Long> {
}
