package com.example.medicare.api.appointment.domain.persistence;


import com.example.medicare.api.appointment.domain.model.entities.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Integer> {
}
