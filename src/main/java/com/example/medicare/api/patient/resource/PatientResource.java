package com.example.medicare.api.patient.resource;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class PatientResource {

        private Long id;
        private String name;
        private String lastname;
        private int age;
        private String email;
        private String password;
        private double height;
        private double weight;
        private double body_mass_index;
        private String fecha_nacimiento;
        private String telefono;
        private String profile_image;
}
