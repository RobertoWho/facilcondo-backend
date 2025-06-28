package com.facilcondo.backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.YearMonth;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "monthly_fees")
public class MonthlyFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "condominium_id")
    private Condominium condominium;

    private YearMonth month; // es. 2025-07

    private Double totalAmount;

    private String description;

    private Boolean isActive = true;
}
