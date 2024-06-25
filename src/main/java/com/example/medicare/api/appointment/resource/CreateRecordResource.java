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
public class CreateRecordResource {
    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @NotNull
    @Column(name = "date")
    private Date date;

    @NotNull
    @Column(name = "description", length = 500)
    private String description;

    @NotNull
    @Column(name = "height")
    private double height;

    @NotNull
    @Column(name = "weight")
    private double weight;

    @NotNull
    @Column(name = "body_mass_index")
    private double body_mass_index;

    @NotNull
    @Column(name = "medicine")
    private String medicine;

    @NotNull
    @Column(name = "natural_factors")
    private String natural_factors;

    @NotNull
    @Column(name = "pathological_factors")
    private String pathological_factors;
}
