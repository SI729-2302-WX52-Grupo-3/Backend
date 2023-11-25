package com.example.medicare.api.appointment.api;

import com.example.medicare.api.appointment.domain.model.entities.Appointment;
import com.example.medicare.api.appointment.domain.service.AppointmentService;
import com.example.medicare.api.appointment.mapping.AppointmentMapper;
import com.example.medicare.api.appointment.resource.AppointmentResource;
import com.example.medicare.api.shared.exception.InternalServerErrorException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;

    @PostMapping
    public ResponseEntity<AppointmentResource> save(@RequestBody Appointment appointment){
        return new ResponseEntity<>(
                appointmentMapper.toResource(appointmentService.save(appointment)),
                org.springframework.http.HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment>  fetchById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(
                appointmentService.fetchById(id),
                org.springframework.http.HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<Appointment>>  fetchAll(){
        return ResponseEntity.ok(appointmentService.fetchAll());
    }

    @PutMapping("/{id}")
    public Appointment update(@RequestBody Appointment appointment, @PathVariable("id") Integer id){
        return appointmentService.update(appointment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id){
        if(appointmentService.deleteById(id))
            return ResponseEntity.ok().build();

        throw new InternalServerErrorException("Appointment", "id", String.valueOf(id), "deleted");
    }
}