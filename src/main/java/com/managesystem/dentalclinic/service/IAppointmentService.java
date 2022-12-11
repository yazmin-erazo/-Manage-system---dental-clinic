package com.managesystem.dentalclinic.service;

import com.managesystem.dentalclinic.entity.AppointmentDto;

import java.util.Set;

public interface IAppointmentService {

    void createAppointment(AppointmentDto appointmentDto);
    AppointmentDto readAppointment(Integer id);
    void updateAppointment(AppointmentDto appointmentDto);
    void deleteAppointment(Integer id);
    Set<AppointmentDto> getAllAppointments();


}
