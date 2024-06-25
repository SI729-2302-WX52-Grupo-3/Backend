package com.example.medicare.api.appointment.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

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

  @NotNull
  @Column(name = "card_holder_name")
  private String card_holder_name;

  @NotNull
  @Column(name = "card_number")
  private String card_number;

  @NotNull
  @Column(name = "card_expiration_date")
  private String card_expiration_date;

  @NotNull
  @Column(name = "card_cvv")
  private String card_cvv;
}