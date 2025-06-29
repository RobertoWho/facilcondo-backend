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
@Table(name = "activities")
public abstract class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    private String title;
    @Size(max = 300)
    private String description;
    @NotNull
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "condominium_id")
    private Condominium condominium;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
    @Size(max = 300)
    private String notes;
    private String attachments;
    private Boolean isActive = true;
}

