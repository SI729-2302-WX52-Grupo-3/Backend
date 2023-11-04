package com.example.repair.repair.appointment.domain.persistence;


import com.example.repair.repair.appointment.domain.model.entities.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Integer> {
}
