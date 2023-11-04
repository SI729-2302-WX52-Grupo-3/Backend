package com.example.repair.repair.doctor.domain.persistence;

import com.example.repair.repair.doctor.domain.model.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
