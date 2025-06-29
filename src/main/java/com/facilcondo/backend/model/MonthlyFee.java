package com.facilcondo.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull
    private YearMonth month; // es. 2025-07

    @NotNull
    private Double totalAmount;

    @Size(max = 300)
    private String description;

    private Boolean isActive = true;
}
