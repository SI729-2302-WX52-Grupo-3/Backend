package com.example.medicare.api.appointment.service;

import com.example.medicare.api.appointment.domain.model.entities.PaymentDetail;
import com.example.medicare.api.appointment.domain.persistence.PaymentDetailRepository;
import com.example.medicare.api.appointment.domain.service.PaymentDetailService;
import com.example.medicare.api.shared.exception.FetchIdNotFoundException;
import com.example.medicare.api.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class PaymentDetailServiceImpl implements PaymentDetailService {

    private final PaymentDetailRepository paymentDetailRepository;

    private final Validator validator;

    @Override
    public PaymentDetail save(PaymentDetail paymentDetail) {
        Set<ConstraintViolation<PaymentDetail>> violations = validator.validate(paymentDetail);
        if(violations.isEmpty()) {
            return paymentDetailRepository.save(paymentDetail);
        }
        throw new ResourceValidationException("PaymentDetail", violations);
    }

    @Override
    public PaymentDetail update (PaymentDetail paymentDetail, Integer id){
        return null;
    }

    @Override
    public PaymentDetail fetchById(Integer id) {
        if(paymentDetailRepository.existsById(id)){
            return paymentDetailRepository.findById(id).orElseThrow();
        }
        throw new FetchIdNotFoundException("PaymentDetail", id);
    }

    @Override
    public boolean deleteById(Integer id) {
        if(paymentDetailRepository.existsById(id)){
            paymentDetailRepository.deleteById(id);
            if(paymentDetailRepository.existsById(id))
                return false;
            return true;
        }
        throw new FetchIdNotFoundException("PaymentDetail", id);
    }

    @Override
    public List<PaymentDetail> fetchAll() {
        return paymentDetailRepository.findAll();
    }
}
