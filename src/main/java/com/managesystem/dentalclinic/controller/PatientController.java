package com.managesystem.dentalclinic.controller;

import com.managesystem.dentalclinic.entity.PatientDto;
import com.managesystem.dentalclinic.exception.ResourceNotFoundException;
import com.managesystem.dentalclinic.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private IPatientService patientService;

    @PostMapping("/create")
    public ResponseEntity<?> createPatient(@RequestBody PatientDto patientDto){
        patientService.createPatient(patientDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public PatientDto getPatient(@PathVariable Integer id) throws ResourceNotFoundException {
        return patientService.readPatient(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> modifyPatient(@RequestBody PatientDto patientDto) throws ResourceNotFoundException {
        patientService.updatePatient(patientDto);
        return ResponseEntity.ok("Paciente actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removePatient(@PathVariable Integer id) throws ResourceNotFoundException {
        patientService.deletePatient(id);
        return ResponseEntity.ok("Paciente eliminado");
    }

    @GetMapping("/list")
    public Collection<PatientDto> getAllPatients(){
        return patientService.getAllPatients();
    }


}
