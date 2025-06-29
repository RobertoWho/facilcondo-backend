package com.facilcondo.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "payment_shares")
public abstract class AbstractPaymentShare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    private Double amount;

    @NotNull
    private Boolean isPaid = false;

    @NotNull
    private LocalDateTime paymentDate;

    private String paymentMethod;

    @Size(max = 300)
    private String notes;

    private Double paidAmount = 0.0;

    private String receiptUrl;
}

