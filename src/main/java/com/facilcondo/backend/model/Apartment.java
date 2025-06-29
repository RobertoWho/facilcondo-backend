package com.facilcondo.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull
    @Size(min = 1, max = 20)
    private String number;

    @Size(max = 20)
    private String floor;

    @Size(max = 50)
    private String buildingBlock;

    @Size(max = 300)
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
