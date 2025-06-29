package com.facilcondo.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "apartments")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String floor;
    private String buildingBlock;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "condominium_id")
    private Condominium condominium;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private User tenant;
}
