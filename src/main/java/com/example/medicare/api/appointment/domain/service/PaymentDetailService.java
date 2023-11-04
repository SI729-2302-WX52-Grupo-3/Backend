package com.example.repair.repair.appointment.domain.service;

import com.example.repair.repair.appointment.domain.model.entities.PaymentDetail;

import java.util.List;

public interface PaymentDetailService {

    PaymentDetail save(PaymentDetail paymentDetail);
    PaymentDetail update(PaymentDetail paymentDetail, Integer id);
    PaymentDetail fetchById(Integer id);
    boolean deleteById(Integer id);
    List<PaymentDetail> fetchAll();
}
