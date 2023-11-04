package com.example.repair.repair.appointment.api;

import com.example.repair.repair.appointment.domain.model.entities.Appointment;
import com.example.repair.repair.appointment.domain.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public Appointment save(@RequestBody Appointment appointment){
        return  appointmentService.save(appointment);
    }

    @GetMapping("/{id}")
    public Appointment fetchById(@PathVariable("id") Integer id){
        return appointmentService.fetchById(id);
    }

    @GetMapping
    public List<Appointment> fetchAll(){
        return appointmentService.fetchAll();
    }

    @PutMapping("/{id}")
    public Appointment update(@RequestBody Appointment appointment, @PathVariable("id") Integer id){
        return appointmentService.update(appointment);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable("id") Integer id){
        return appointmentService.deleteById(id);
    }
}