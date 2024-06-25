package com.example.medicare.api.patient.api;

import com.example.medicare.api.patient.domain.model.entities.Patient;
import com.example.medicare.api.patient.domain.service.PatientService;
import com.example.medicare.api.patient.mapping.PatientMapper;
import com.example.medicare.api.patient.resource.CreatePatientResource;
import com.example.medicare.api.patient.resource.PatientResource;
import com.example.medicare.api.shared.exception.InternalServerErrorException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("patients")
public class PatientController {

    private final PatientService patientService;
    private final PatientMapper patientMapper;

    @PostMapping
    public ResponseEntity<PatientResource> save(@RequestBody CreatePatientResource resource) {
        return new ResponseEntity<>(
                patientMapper.toResource(patientService.save(patientMapper.toEntity(resource))),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<Patient>> fetchAll() {
        return ResponseEntity.ok(patientService.fetchAll());
    }

    @PutMapping()
    public Patient update(@RequestBody Patient patient) {
        return patientService.update(patient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResource> fetchById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(
                patientMapper.toResource(patientService.fetchById(id)),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        if(patientService.deleteById(id))
            return ResponseEntity.ok().build();

        throw new InternalServerErrorException("Patient", "id", String.valueOf(id), "deleted");
    }

    @PostMapping("/login")
    public ResponseEntity<PatientResource> login(@RequestBody LoginRequest request) {
        Patient patient = patientService.login(request.email, request.password);
        if (patient != null) {
            return new ResponseEntity<>(
                    patientMapper.toResource(patient),
                    HttpStatus.OK
            );
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    static class LoginRequest {
        public String email;
        public String password;
    }

}
