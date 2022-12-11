package com.managesystem.dentalclinic.controller;

import com.managesystem.dentalclinic.entity.PatientDto;
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
        return new ResponseEntity<>(patientDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public PatientDto getPatient(@PathVariable Integer id){
        return patientService.readPatient(id);
    }

    @PutMapping
    public ResponseEntity<?> modifyPatient(@RequestBody PatientDto patientDto){
        patientService.updatePatient(patientDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public ResponseEntity<?> removePatient(@PathVariable Integer id){
        patientService.deletePatient(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<PatientDto> getAllPatients(){
        return patientService.getAllPatients();
    }


}
