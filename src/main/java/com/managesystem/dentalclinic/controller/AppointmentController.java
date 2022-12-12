package com.managesystem.dentalclinic.controller;

import com.managesystem.dentalclinic.entity.AppointmentDto;
import com.managesystem.dentalclinic.exception.ResourceNotFoundException;
import com.managesystem.dentalclinic.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private IAppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentDto appointmentDto) {
        appointmentService.createAppointment(appointmentDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public AppointmentDto getAppointment(@PathVariable Integer id) throws ResourceNotFoundException {
        return appointmentService.readAppointment(id);
    }

    @PutMapping
    public ResponseEntity<?> modifyAppointment(@RequestBody AppointmentDto appointmentDto) throws ResourceNotFoundException {
        appointmentService.updateAppointment(appointmentDto);
        return ResponseEntity.ok("Cita actualizada");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeAppointment(@PathVariable Integer id) throws ResourceNotFoundException {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.ok("Cita eliminada");
    }

    @GetMapping
    public Collection<AppointmentDto> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }



}
