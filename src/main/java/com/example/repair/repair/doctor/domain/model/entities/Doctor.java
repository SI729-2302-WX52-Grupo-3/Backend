package com.example.repair.repair.doctor.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 7, max = 50)
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 7, max = 50)
    @Column(name = "lastname", length = 50, nullable = false)
    private String lastname;

    @NotNull
    @NotBlank
    @Size(min = 10, max = 50)
    @Column(name = "speciality", length = 50, nullable = false)
    private String speciality;

}
