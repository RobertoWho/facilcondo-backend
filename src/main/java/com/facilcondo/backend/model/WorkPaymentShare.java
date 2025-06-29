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
@Table(name = "work_payment_shares")
public class WorkPaymentShare extends AbstractPaymentShare {

    @ManyToOne
    @JoinColumn(name = "work_id")
    private Work work;
}
