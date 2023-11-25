package com.example.medicare.api.appointment.mapping;

import com.example.medicare.api.appointment.domain.model.entities.Appointment;
import com.example.medicare.api.appointment.resource.AppointmentResource;
import com.example.medicare.api.appointment.resource.CreateAppointmentResource;
import com.example.medicare.api.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class AppointmentMapper implements Serializable {
    @Autowired
    EnhancedModelMapper modelMapper;

    public Appointment toEntity(CreateAppointmentResource resource){
        return modelMapper.map(resource, Appointment.class);
    }

    public AppointmentResource toResource(Appointment entity){
        return modelMapper.map(entity, AppointmentResource.class);
    }
}
