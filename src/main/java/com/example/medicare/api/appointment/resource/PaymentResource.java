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
public class PaymentResource {

    private Integer id;
    private Appointment appointment;
    private double subtotal;
    private double discount;
    private double retention_percentage;
    private double retention_amount;
}
