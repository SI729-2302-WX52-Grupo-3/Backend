package com.example.medicare.api.appointment.resource;

import com.example.medicare.api.appointment.domain.model.entities.Appointment;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class RecordResource {

    private Appointment appointment;
    private Date date;
    private String description;
}
