package com.example.medicare.api.patient.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("patientMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public PatientMapper patientMapper() {
        return new PatientMapper();
    }
}
