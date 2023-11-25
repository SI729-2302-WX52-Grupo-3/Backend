package com.example.medicare.api.patient.resource;

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
    @Size(min = 7, max = 50)
    private String name;

    @NotNull
    @NotNull
    @NotBlank
    @Size(min = 7, max = 50)
    private String lastname;

    @NotNull
    @Min(value = 18)
    @Max(value = 65)
    private int age;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 6, max = 50)
    private String password;



}
