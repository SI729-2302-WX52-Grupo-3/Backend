package com.example.repair.repair.doctor.domain.service;

import com.example.repair.repair.doctor.domain.model.entities.Doctor;

import java.util.List;

public interface DoctorService  {

    Doctor save(Doctor doctor);
    Doctor update(Doctor doctor, Integer id);
    Doctor fetchById(Integer id);
    boolean deleteById(Integer id);
    List<Doctor> fetchAll();

}
