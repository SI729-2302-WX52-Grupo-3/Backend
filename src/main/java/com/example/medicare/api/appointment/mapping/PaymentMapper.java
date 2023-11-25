package com.example.medicare.api.appointment.mapping;

import com.example.medicare.api.appointment.domain.model.entities.Payment;
import com.example.medicare.api.appointment.resource.CreatePaymentResource;
import com.example.medicare.api.appointment.resource.PaymentResource;
import com.example.medicare.api.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class PaymentMapper implements Serializable {

    @Autowired
    EnhancedModelMapper modelMapper;

    public Payment toEntity(CreatePaymentResource resource){
        return modelMapper.map(resource, Payment.class);
    }

    public PaymentResource toResource(Payment entity){
        return modelMapper.map(entity, PaymentResource.class);
    }

}
