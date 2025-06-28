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
@Table(name = "activities")
public abstract class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "condominium_id")
    private Condominium condominium;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    private String notes;
    private String attachments;
    private Boolean isActive = true;
}

