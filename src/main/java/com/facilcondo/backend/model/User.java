package com.facilcondo.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @NotNull
    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull
    @Size(min = 6, max = 100)
    @Column(nullable = false)
    private String password;

    @NotNull
    private String role; // e.g. admin, owner, tenant

    @Size(max = 20)
    private String phoneNumber;

    private String language;

    private Boolean isActive = true;
}
