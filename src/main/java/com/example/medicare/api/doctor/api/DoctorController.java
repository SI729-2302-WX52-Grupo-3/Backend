package com.example.medicare.api.doctor.api;

import com.example.medicare.api.doctor.domain.model.entities.Doctor;
import com.example.medicare.api.doctor.domain.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public List<Doctor> fetchAll() {
        return doctorService.fetchAll();
    }

    @PostMapping
    public Doctor save(@RequestBody Doctor doctor) {
        return doctorService.save(doctor);
    }

    @PutMapping("/{id}")
    public Doctor update(@RequestBody Doctor doctor, @PathVariable("id") Integer id) {
        return doctorService.update(doctor, id);
    }

    @GetMapping("/{id}")
    public Doctor fetchById(@PathVariable("id") Integer id) {
        return doctorService.fetchById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable("id") Integer id) {
        return doctorService.deleteById(id);
    }
}
