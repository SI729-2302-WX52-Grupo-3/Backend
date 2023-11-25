package com.example.medicare.api.appointment.resource;

import com.example.medicare.api.appointment.domain.model.entities.Appointment;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentResource {
    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @NotNull
    @Min(value = 0)
    @Column(name = "subtotal", columnDefinition = "decimal(10,2)")
    private double subtotal;

    @NotNull
    @Min(value = 0)
    @Column(name = "discount", columnDefinition = "decimal(10,2)")
    private double discount;

    @NotNull
    @Min(value = 0)
    @Column(name = "retention_percentage", columnDefinition = "decimal(10,2)")
    private double retention_percentage;

    @NotNull
    @Min(value = 0)
    @Column(name = "retention_amount", columnDefinition = "decimal(10,2)")
    private double retention_amount;
}
