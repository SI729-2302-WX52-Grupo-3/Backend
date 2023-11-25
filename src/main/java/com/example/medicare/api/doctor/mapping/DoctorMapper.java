package com.example.medicare.api.doctor.mapping;

import com.example.medicare.api.doctor.domain.model.entities.Doctor;
import com.example.medicare.api.doctor.resource.CreateDoctorResource;
import com.example.medicare.api.doctor.resource.DoctorResource;
import com.example.medicare.api.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class DoctorMapper implements Serializable {

    @Autowired
    EnhancedModelMapper modelMapper;

    public Doctor toEntity(CreateDoctorResource resource){
        return modelMapper.map(resource, Doctor.class);
    }

    public DoctorResource toResource(Doctor entity){
        return modelMapper.map(entity, DoctorResource.class);
    }
}
