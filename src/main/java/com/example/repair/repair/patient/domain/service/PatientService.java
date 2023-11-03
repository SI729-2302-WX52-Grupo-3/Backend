package com.example.repair.repair.patient.domain.service;


import com.example.repair.repair.patient.domain.model.entities.Patient;

import java.util.List;

public interface PatientService {

    Patient save(Patient patient);
    Patient update(Patient patient, Integer id);
    Patient fetchById(Integer id);
    boolean deleteById(Integer id);
    List<Patient> fetchAll();
}
