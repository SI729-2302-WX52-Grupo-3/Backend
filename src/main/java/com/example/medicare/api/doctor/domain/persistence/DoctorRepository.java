package com.example.medicare.api.doctor.domain.persistence;

import com.example.medicare.api.doctor.domain.model.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Doctor findByEmailAndPassword(String email, String password);
}
