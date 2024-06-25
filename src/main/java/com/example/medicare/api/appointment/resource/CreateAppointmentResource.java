package com.example.medicare.api.appointment.resource;

import com.example.medicare.api.doctor.domain.model.entities.Doctor;
import com.example.medicare.api.patient.domain.model.entities.Patient;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateAppointmentResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "description", length = 500)
    private String description;

    @JoinColumn(name = "patient_id")
    private Integer patient_id;

    @JoinColumn(name = "doctor_id")
    private Integer doctor_id;
}
