package com.example.repair.repair.appointment.domain.service;

import com.example.repair.repair.appointment.domain.model.entities.Payment;

import java.util.List;

public interface PaymentService {

  Payment save(Payment payment);
  Payment update(Payment payment, Integer id);
  Payment fetchById(Integer id);
  boolean deleteById(Integer id);
  List<Payment> fetchAll();
}