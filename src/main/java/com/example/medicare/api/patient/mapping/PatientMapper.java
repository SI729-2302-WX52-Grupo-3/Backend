package com.example.medicare.api.patient.mapping;

import com.example.medicare.api.patient.domain.model.entities.Patient;
import com.example.medicare.api.patient.resource.CreatePatientResource;
import com.example.medicare.api.patient.resource.PatientResource;
import com.example.medicare.api.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class PatientMapper implements Serializable {
    @Autowired
    EnhancedModelMapper modelMapper;

    public Patient toEntity(CreatePatientResource resource){
        return modelMapper.map(resource, Patient.class);
    }

    public PatientResource toResource(Patient entity){
        return modelMapper.map(entity, PatientResource.class);
    }
}
