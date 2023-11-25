package com.example.medicare.api.patient.resource;

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
}
