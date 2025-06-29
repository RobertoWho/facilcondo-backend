package com.facilcondo.backend.repository;

import com.facilcondo.backend.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<Work, Long> {
}
