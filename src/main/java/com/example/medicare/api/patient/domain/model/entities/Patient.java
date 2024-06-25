package com.example.medicare.api.patient.domain.model.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @NotNull
    @Column(name = "age")
    private int age;

    @NotNull
    @NotBlank
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotNull
    @NotBlank
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "height")
    private double height;

    @NotNull
    @Column(name = "weight")
    private double weight;

    @NotNull
    @Column(name = "body_mass_index")
    private double body_mass_index;

    @Column(name = "fecha_nacimiento")
    private String fecha_nacimiento;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "profile_image")
    private String profile_image;
}
