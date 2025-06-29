package com.facilcondo.backend.repository;

import com.facilcondo.backend.model.MonthlyFee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlyFeeRepository extends JpaRepository<MonthlyFee, Long> {
}
