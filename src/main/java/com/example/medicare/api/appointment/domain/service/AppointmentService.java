package com.example.medicare.api.appointment.domain.service;

import com.example.medicare.api.appointment.domain.model.entities.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment save(Appointment appointment);
    Appointment update(Appointment appointment);
    Appointment fetchById(Integer id);
    boolean deleteById(Integer id);
    List<Appointment> fetchAll();
}