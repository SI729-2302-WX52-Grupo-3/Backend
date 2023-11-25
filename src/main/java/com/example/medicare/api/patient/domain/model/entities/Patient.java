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
    @Size(min = 7, max = 50)
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 7, max = 50)
    @Column(name = "lastname", length = 50, nullable = false)
    private String lastname;

    @NotNull
    @Min(value = 18)
    @Max(value = 65)
    @Column(name = "age", columnDefinition = "smallint")
    private int age;

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
