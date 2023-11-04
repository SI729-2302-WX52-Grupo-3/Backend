package com.example.repair.repair.appointment.domain.persistence;

import com.example.repair.repair.appointment.domain.model.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}