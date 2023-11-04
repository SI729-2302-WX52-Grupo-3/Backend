package com.example.medicare.api.doctor.service;

import com.example.medicare.api.doctor.domain.model.entities.Doctor;
import com.example.medicare.api.doctor.domain.persistence.DoctorRepository;
import com.example.medicare.api.doctor.domain.service.DoctorService;
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
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    private final Validator validator;

    @Override
    public Doctor save(Doctor doctor) {
        Set<ConstraintViolation<Doctor>> violations = validator.validate(doctor);
        if(violations.isEmpty()) {
            return doctorRepository.save(doctor);
        }
        throw new ResourceValidationException("Doctor", violations);
    }

    @Override
    public Doctor update(Doctor doctor, Integer id) {
        return null;
    }

    @Override
    public Doctor fetchById(Integer id) {
        if(doctorRepository.existsById(id)){
            return doctorRepository.findById(id).orElseThrow();
        }
        throw new FetchIdNotFoundException("Doctor", id);
    }

    @Override
    public boolean deleteById(Integer id) {
        if(doctorRepository.existsById(id)){
            doctorRepository.deleteById(id);
            if(doctorRepository.existsById(id))
                return false;
            return true;
        }
        throw new FetchIdNotFoundException("Doctor", id);
    }

    @Override
    public List<Doctor> fetchAll() {
        return doctorRepository.findAll();
    }
}
