package com.managesystem.dentalclinic.controller;

import com.managesystem.dentalclinic.entity.AppointmentDto;
import com.managesystem.dentalclinic.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private IAppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentDto appointmentDto) {
        appointmentService.createAppointment(appointmentDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public AppointmentDto getAppointment(@PathVariable Integer id) {
        return appointmentService.readAppointment(id);
    }

    @PutMapping
    public ResponseEntity<?> modifyAppointment(@RequestBody AppointmentDto appointmentDto) {
        appointmentService.updateAppointment(appointmentDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeAppointment(@PathVariable Integer id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<AppointmentDto> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }



}
