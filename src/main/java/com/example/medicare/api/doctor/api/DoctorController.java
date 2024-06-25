package com.example.medicare.api.doctor.api;

import com.example.medicare.api.doctor.domain.model.entities.Doctor;
import com.example.medicare.api.doctor.domain.service.DoctorService;
import com.example.medicare.api.doctor.mapping.DoctorMapper;
import com.example.medicare.api.doctor.resource.DoctorResource;
import com.example.medicare.api.shared.exception.InternalServerErrorException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("doctors")
public class DoctorController {

    private final DoctorService doctorService;
    private final DoctorMapper doctorMapper;

    @GetMapping
    public ResponseEntity<List<Doctor>>fetchAll() {
        return ResponseEntity.ok(doctorService.fetchAll());
    }

    @PostMapping
    public ResponseEntity<Doctor>  save(@RequestBody Doctor doctor) {
        return new ResponseEntity<>(
                doctorService.save(doctor),
                HttpStatus.CREATED
        );
    }

    @PutMapping()
    public Doctor update(@RequestBody Doctor doctor) {
        return doctorService.update(doctor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResource> fetchById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(
                doctorMapper.toResource(doctorService.fetchById(id)),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        if(doctorService.deleteById(id))
            return ResponseEntity.ok().build();

        throw new InternalServerErrorException("Doctor", "id", String.valueOf(id), "deleted");
    }

    @PostMapping("/login")
    public ResponseEntity<DoctorResource>  login(@RequestBody LoginRequest request){
        Doctor doctor = doctorService.login(request.email, request.password);
        if(doctor != null) {
            return new ResponseEntity<>(
                    doctorMapper.toResource(doctor),
                    HttpStatus.OK
            );
        }
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    static class LoginRequest {
        public String email;
        public String password;
    }
}
