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
@Table(name = "condominiums")
public class Condominium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    private String name;
    @NotNull
    @Size(min = 2, max = 100)
    private String street;
    @NotNull
    @Size(min = 1, max = 20)
    private String streetNumber;

    @NotNull
    @Size(min = 2, max = 20)
    private String zipCode;

    @NotNull
    @Size(min = 2, max = 50)
    private String city;

    @Size(max = 50)
    private String province;
    @Size(max = 50)
    private String region;
    @Size(max = 50)
    private String country;

    @ManyToOne
    @JoinColumn(name = "administrator_id")
    private User administrator;

    @Size(max = 300)
    private String notes;

    @NotNull
    private Boolean isActive = true;
}
