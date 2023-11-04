package com.example.medicare.api.patient.api;

import com.example.medicare.api.patient.domain.model.entities.Patient;
import com.example.medicare.api.patient.domain.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("patients")
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public Patient save(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    @GetMapping
    public List<Patient> fetchAll() {
        return patientService.fetchAll();
    }

    @PutMapping("/{id}")
    public Patient update(@RequestBody Patient patient, @PathVariable("id") Integer id) {
        return patientService.update(patient, id);
    }

    @GetMapping("/{id}")
    public Patient fetchById(@PathVariable("id") Integer id) {
        return patientService.fetchById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable("id") Integer id) {
        return patientService.deleteById(id);
    }


}
