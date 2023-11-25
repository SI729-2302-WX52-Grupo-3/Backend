package com.example.medicare.api.appointment.mapping;

import com.example.medicare.api.appointment.domain.model.entities.Record;
import com.example.medicare.api.appointment.resource.CreateRecordResource;
import com.example.medicare.api.appointment.resource.RecordResource;
import com.example.medicare.api.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class RecordMapper implements Serializable {

    @Autowired
    EnhancedModelMapper modelMapper;

    public Record toEntity(CreateRecordResource resource){
        return modelMapper.map(resource, Record.class);
    }

    public RecordResource toResource(Record entity){
        return modelMapper.map(entity, RecordResource.class);
    }
}
