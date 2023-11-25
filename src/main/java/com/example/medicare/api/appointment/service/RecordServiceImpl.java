package com.example.medicare.api.appointment.service;

import com.example.medicare.api.appointment.domain.model.entities.Record;
import com.example.medicare.api.appointment.domain.persistence.RecordRepository;
import com.example.medicare.api.appointment.domain.service.RecordService;
import com.example.medicare.api.shared.exception.FetchIdNotFoundException;
import com.example.medicare.api.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class RecordServiceImpl implements RecordService {

    private final RecordRepository recordRepository;

    private final Validator validator;

    @Override
    public Record save(Record record) {
        Set<ConstraintViolation<Record>> violations = validator.validate(record);
        if(violations.isEmpty()) {
            return recordRepository.save(record);
        }
        throw new ResourceValidationException("Record", violations);
    }

    @Override
    public Record update(Record record, Integer id) {
        Record existingRecord = fetchById(id);

        if(existingRecord != null){
            existingRecord.setAppointment(record.getAppointment());
            existingRecord.setDate(record.getDate());
            existingRecord.setDescription(record.getDescription());

            return recordRepository.save(existingRecord);
        }else{
            throw new FetchIdNotFoundException("Record", id);
        }

    }

    @Override
    public Record fetchById(Integer id) {
        if(recordRepository.existsById(id)){
            return recordRepository.findById(id).orElseThrow();
        }
        throw new FetchIdNotFoundException("Record", id);
    }

    @Override
    public boolean deleteById(Integer id) {
        if(recordRepository.existsById(id)){
            recordRepository.deleteById(id);
            if(recordRepository.existsById(id))
                return false;
            return true;
        }
        throw new FetchIdNotFoundException("Record", id);
    }

    @Override
    public List<Record> fetchAll() {
        return recordRepository.findAll();
    }


}
