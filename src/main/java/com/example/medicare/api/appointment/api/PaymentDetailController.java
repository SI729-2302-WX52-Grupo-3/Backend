package com.example.medicare.api.appointment.api;

import com.example.medicare.api.appointment.domain.model.entities.PaymentDetail;
import com.example.medicare.api.appointment.domain.service.PaymentDetailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("payment-details")
public class PaymentDetailController {

    private final PaymentDetailService paymentDetailService;

    @PostMapping
    public PaymentDetail save(PaymentDetail paymentDetail) {
        return paymentDetailService.save(paymentDetail);
    }

    @GetMapping
    public List<PaymentDetail> fetchAll() {
        return paymentDetailService.fetchAll();
    }

    @PutMapping("/{id}")
    public PaymentDetail update(PaymentDetail paymentDetail, @PathVariable("id") Integer id) {
        return paymentDetailService.update(paymentDetail, id);
    }

    @GetMapping("/{id}")
    public PaymentDetail fetchById(@PathVariable("id") Integer id) {
        return paymentDetailService.fetchById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable("id") Integer id) {
        return paymentDetailService.deleteById(id);
    }
}
