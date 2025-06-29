package com.facilcondo.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "condominiums")
public class Condominium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String street;
    private String streetNumber;
    private String zipCode;
    private String city;
    private String province;
    private String region;
    private String country;

    @ManyToOne
    @JoinColumn(name = "administrator_id")
    private User administrator;

    private String notes;

    private Boolean isActive = true;
}
