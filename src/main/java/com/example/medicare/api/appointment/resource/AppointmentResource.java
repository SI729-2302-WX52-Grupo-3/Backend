package com.example.medicare.api.appointment.resource;

import com.example.medicare.api.doctor.domain.model.entities.Doctor;
import com.example.medicare.api.patient.domain.model.entities.Patient;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResource {

    private Long id;
    private Date date;
    private String description;
    private Patient patient;
    private Doctor doctor;

}
