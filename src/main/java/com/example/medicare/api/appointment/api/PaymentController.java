package com.example.medicare.api.appointment.api;

import com.example.medicare.api.appointment.domain.model.entities.Payment;
import com.example.medicare.api.appointment.domain.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("payments")
public class PaymentController {

  private final PaymentService paymentService;

  @PostMapping
  public Payment save(Payment payment) {
    return paymentService.save(payment);
  }

  @GetMapping
  public List<Payment> fetchAll() {
    return paymentService.fetchAll();
  }

  @PutMapping("/{id}")
  public Payment update(Payment payment, @PathVariable("id") Integer id) {
    return paymentService.update(payment, id);
  }

}