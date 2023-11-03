package com.example.repair.repair.patient.domain.persistence;

import com.example.repair.repair.patient.domain.model.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
