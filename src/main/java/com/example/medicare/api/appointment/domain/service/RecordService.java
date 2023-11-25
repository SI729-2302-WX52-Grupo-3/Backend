package com.example.medicare.api.appointment.domain.service;

import com.example.medicare.api.appointment.domain.model.entities.Record;

import java.util.List;

public interface RecordService {
    Record save(Record record);
    Record update(Record record, Integer id);
    Record fetchById(Integer id);
    boolean deleteById(Integer id);
    List<Record> fetchAll();
}
