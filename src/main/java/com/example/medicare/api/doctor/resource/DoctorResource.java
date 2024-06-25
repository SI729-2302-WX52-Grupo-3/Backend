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
public class DoctorResource {

    private Integer id;
    private String name;
    private String lastname;
    private String specialty;
    private String email;
    private String password;
    private double height;
    private double weight;
    private double body_mass_index;
    private String profile_image;
    private String puntuation;
    private String costo;
}
