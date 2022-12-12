package com.managesystem.dentalclinic.service;

import com.managesystem.dentalclinic.entity.AppointmentDto;
import com.managesystem.dentalclinic.exception.ResourceNotFoundException;

import java.util.Set;

public interface IAppointmentService {

    void createAppointment(AppointmentDto appointmentDto);
    AppointmentDto readAppointment(Integer id) throws ResourceNotFoundException;
    void updateAppointment(AppointmentDto appointmentDto) throws ResourceNotFoundException;
    void deleteAppointment(Integer id) throws ResourceNotFoundException;
    Set<AppointmentDto> getAllAppointments();


}
