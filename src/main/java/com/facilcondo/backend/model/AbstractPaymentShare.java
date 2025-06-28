package com.facilcondo.backend.model;

import jakarta.persistence.*;
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

    private Double amount;

    private Boolean isPaid = false;

    private LocalDateTime paymentDate;

    private String paymentMethod;

    private String notes;

    private Double paidAmount = 0.0;

    private String receiptUrl;
}

