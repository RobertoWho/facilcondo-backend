package com.facilcondo.backend.repository;

import com.facilcondo.backend.model.MonthlyFeePayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlyFeePaymentRepository extends JpaRepository<MonthlyFeePayment, Long> {
}
