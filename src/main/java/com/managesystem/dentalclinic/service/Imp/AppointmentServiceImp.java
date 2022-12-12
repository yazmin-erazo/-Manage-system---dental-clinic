package com.managesystem.dentalclinic.service.Imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.managesystem.dentalclinic.entity.Appointment;
import com.managesystem.dentalclinic.entity.AppointmentDto;
import com.managesystem.dentalclinic.entity.DentistDto;
import com.managesystem.dentalclinic.exception.ResourceNotFoundException;
import com.managesystem.dentalclinic.repository.IAppointmentRepository;
import com.managesystem.dentalclinic.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AppointmentServiceImp implements IAppointmentService {

    @Autowired
    private IAppointmentRepository appointmentRepository;

    @Autowired
    ObjectMapper mapper;

    private void save(AppointmentDto appointmentDto) {
        Appointment appointment = mapper.convertValue(appointmentDto, Appointment.class);
        appointmentRepository.save(appointment);
    }

    @Override
    public void createAppointment(AppointmentDto appointmentDto) {
        save(appointmentDto);
    }

    @Override
    public AppointmentDto readAppointment(Integer id) throws ResourceNotFoundException {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        AppointmentDto appointmentDto = null;

        if (appointment.isEmpty())
            throw new ResourceNotFoundException("La cita con id " + id + " no fue encontrada");
        else
            appointmentDto = mapper.convertValue(appointment, AppointmentDto.class);

        return appointmentDto;
    }

    @Override
    public void updateAppointment(AppointmentDto appointmentDto) throws ResourceNotFoundException {
        if (appointmentRepository.findById(appointmentDto.getId()).isEmpty())
            throw new ResourceNotFoundException("No existe la cita con id " + appointmentDto.getId());
        save(appointmentDto);
    }

    @Override
    public void deleteAppointment(Integer id) throws ResourceNotFoundException {
        if(appointmentRepository.findById(id).isEmpty())
            throw new ResourceNotFoundException("No existe una cita con id: " + id);
        appointmentRepository.deleteById(id);
    }

    @Override
    public Set<AppointmentDto> getAllAppointments() {
        List<Appointment> appointmentList = appointmentRepository.findAll();
        Set<AppointmentDto> appointmentDto = new HashSet<>();

        for (Appointment appointment : appointmentList ) {
            appointmentDto.add(mapper.convertValue(appointment, AppointmentDto.class));
        }

        return appointmentDto;
    }
}
