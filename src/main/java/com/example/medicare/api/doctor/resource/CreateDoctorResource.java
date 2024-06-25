package com.example.medicare.api.doctor.resource;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateDoctorResource {

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "lastname")
    private String lastname;

    @NotNull
    @Column(name = "specialty")
    private String specialty;

    @NotNull
    @NotBlank
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotNull
    @Column(name = "password", length = 50, nullable = false)
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

    @Column(name ="profile_image")
    private String profile_image;

    @Column(name = "puntuacion")
    private String puntuation;

    @Column(name = "costo")
    private String costo;
}
