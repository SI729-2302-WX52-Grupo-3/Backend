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

    @NotNull
    @NotBlank
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 6, max = 50)
    @Column(name = "password", length = 50, nullable = false)
    private String password;
}
