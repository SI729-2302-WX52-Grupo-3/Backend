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
    public Doctor update(Doctor doctor) {
        Doctor existingDoctor = fetchById(doctor.getId());

        if(existingDoctor != null){
            existingDoctor.setSpecialty(doctor.getSpecialty());
            existingDoctor.setEmail(doctor.getEmail());
            existingDoctor.setPassword(doctor.getPassword());
            existingDoctor.setName(doctor.getName());
            existingDoctor.setLastname(doctor.getLastname());
            existingDoctor.setCosto(doctor.getCosto());
            existingDoctor.setProfile_image(doctor.getProfile_image());
            existingDoctor.setPuntuation(doctor.getPuntuation());
            existingDoctor.setWeight(doctor.getWeight());
            existingDoctor.setHeight(doctor.getHeight());
            existingDoctor.setBody_mass_index(doctor.getBody_mass_index());
            existingDoctor.setProfile_image(doctor.getProfile_image());


            return doctorRepository.save(existingDoctor);

        }
        else{
            throw new FetchIdNotFoundException("Doctor", doctor.getId());
        }

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

    @Override
    public Doctor login(String email, String password) {
        return doctorRepository.findByEmailAndPassword(email, password);
    }
}
