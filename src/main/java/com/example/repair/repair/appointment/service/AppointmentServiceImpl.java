package com.example.repair.repair.appointment.service;

import com.example.repair.repair.appointment.domain.model.entities.Appointment;
import com.example.repair.repair.appointment.domain.persistence.AppointmentRepository;
import com.example.repair.repair.appointment.domain.service.AppointmentService;
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
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    private final Validator validator;

    @Override
    public Appointment save(Appointment appointment) {
        Set<ConstraintViolation<Appointment>> violations = validator.validate(appointment);
        if(violations.isEmpty()) {
            return appointmentRepository.save(appointment);
        }
        throw new ResourceValidationException("Appointment", violations);
    }

    @Override
    public Appointment update(Appointment appointment) {
        return null;
    }

    @Override
    public Appointment fetchById(Integer id) {
        if(appointmentRepository.existsById(id)){
            return appointmentRepository.findById(id).orElseThrow();
        }
        throw new FetchIdNotFoundException("Appointment", id);
    }

    @Override
    public boolean deleteById(Integer id) {
        if(appointmentRepository.existsById(id)){
            appointmentRepository.deleteById(id);
            if(appointmentRepository.existsById(id))
                return false;
            return true;
        }
        throw new FetchIdNotFoundException("Appointment", id);
    }

    @Override
    public List<Appointment> fetchAll() {
        return appointmentRepository.findAll();
    }
}