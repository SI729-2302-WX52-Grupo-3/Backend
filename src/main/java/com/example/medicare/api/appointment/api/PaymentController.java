package com.example.medicare.api.appointment.api;

import com.example.medicare.api.appointment.domain.model.entities.Payment;
import com.example.medicare.api.appointment.domain.service.PaymentService;
import com.example.medicare.api.appointment.mapping.PaymentMapper;
import com.example.medicare.api.appointment.resource.CreatePaymentResource;
import com.example.medicare.api.appointment.resource.PaymentResource;
import com.example.medicare.api.shared.exception.InternalServerErrorException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("payments")
public class PaymentController {

  private final PaymentService paymentService;
  private final PaymentMapper paymentMapper;

  @PostMapping
  public ResponseEntity<PaymentResource> save(CreatePaymentResource payment) {
    return new ResponseEntity<>(
        paymentMapper.toResource(paymentService.save(paymentMapper.toEntity(payment))),
        HttpStatus.CREATED
    );
  }

  @GetMapping
  public ResponseEntity<List<Payment>> fetchAll() {
    return ResponseEntity.ok(paymentService.fetchAll());
  }

  @PutMapping("/{id}")
  public Payment update(Payment payment, @PathVariable("id") Integer id) {
    return paymentService.update(payment, id);
  }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResource> fetchById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(
                paymentMapper.toResource(paymentService.fetchById(id)),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        if(paymentService.deleteById(id))
            return ResponseEntity.ok().build();

        throw new InternalServerErrorException("Payment", "id", String.valueOf(id), "deleted");
    }
}