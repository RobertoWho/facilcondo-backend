package com.facilcondo.backend.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "monthly_fee_payments")
public class MonthlyFeePayment extends AbstractPaymentShare {

    @ManyToOne
    @JoinColumn(name = "monthly_fee_id")
    private MonthlyFee monthlyFee;
}
