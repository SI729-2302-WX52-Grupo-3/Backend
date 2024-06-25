package com.example.medicare.api.patient.resource;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreatePatientResource {

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
