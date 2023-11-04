package com.example.repair.repair.appointment.service;

import com.example.repair.repair.appointment.domain.model.entities.Payment;
import com.example.repair.repair.appointment.domain.persistence.PaymentRepository;
import com.example.repair.repair.appointment.domain.service.PaymentService;
import com.example.repair.repair.shared.exception.FetchIdNotFoundException;
import com.example.repair.repair.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

  private  final PaymentRepository paymentRepository;

  private final Validator validator;

  @Override
  public Payment save(Payment payment) {
    Set<ConstraintViolation<Payment>> violations = validator.validate(payment);
    if(violations.isEmpty()) {
      return paymentRepository.save(payment);
    }
    throw new ResourceValidationException("Payment", violations);
  }

  @Override
  public Payment update(Payment payment, Integer id) {
    return null;
  }

  @Override
  public Payment fetchById(Integer id) {
    if(paymentRepository.existsById(id)){
      return paymentRepository.findById(id).orElseThrow();
    }
    throw new FetchIdNotFoundException("Payment", id);
  }

  @Override
  public boolean deleteById(Integer id) {
    if(paymentRepository.existsById(id)){
      paymentRepository.deleteById(id);
      if(paymentRepository.existsById(id))
        return false;
      return true;
    }
    throw new FetchIdNotFoundException("Payment", id);
  }

  @Override
  public List<Payment> fetchAll() {
    return paymentRepository.findAll();
  }
}