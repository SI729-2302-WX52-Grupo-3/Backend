package com.example.medicare.api.patient.service;

import com.example.medicare.api.shared.exception.FetchIdNotFoundException;
import com.example.medicare.api.shared.exception.ResourceValidationException;
import com.example.medicare.api.patient.domain.model.entities.Patient;
import com.example.medicare.api.patient.domain.persistence.PatientRepository;
import com.example.medicare.api.patient.domain.service.PatientService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class PatientServiceImpl implements PatientService{

    private final PatientRepository patientRepository;

    private final Validator validator;

    @Override
    public Patient save(Patient patient) {
        Set<ConstraintViolation<Patient>> violations = validator.validate(patient);
        if(violations.isEmpty()) {
            return patientRepository.save(patient);
        }
        throw new ResourceValidationException("Patient", violations);
    }

    @Override
    public Patient update (Patient patient, Integer id){
        return null;
    }

    @Override
    public Patient fetchById(Integer id) {
        if(patientRepository.existsById(id)){
            return patientRepository.findById(id).orElseThrow();
        }
        throw new FetchIdNotFoundException("Patient", id);
    }

    @Override
    public boolean deleteById(Integer id) {
        if(patientRepository.existsById(id)){
            patientRepository.deleteById(id);
            if(patientRepository.existsById(id))
                return false;
            return true;
        }
        throw new FetchIdNotFoundException("Patient", id);
    }

    @Override
    public List<Patient> fetchAll() {
        return patientRepository.findAll();
    }

}
