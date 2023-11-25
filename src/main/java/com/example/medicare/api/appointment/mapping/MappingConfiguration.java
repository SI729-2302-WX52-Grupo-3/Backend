package com.example.medicare.api.appointment.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("appointmentMappingConfiguration")
public class MappingConfiguration {
     @Bean
     public AppointmentMapper appointmentMapper() {
         return new AppointmentMapper();
     }

     @Bean
    public RecordMapper recordMapper() {
        return new RecordMapper();
    }

    @Bean
    public PaymentMapper paymentMapper() {
        return new PaymentMapper();
    }
}
