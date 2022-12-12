package com.managesystem.dentalclinic.service;

import com.managesystem.dentalclinic.entity.PatientDto;
import com.managesystem.dentalclinic.exception.ResourceNotFoundException;

import java.util.Set;

public interface IPatientService {
    PatientDto createPatient(PatientDto patientDto);
    PatientDto readPatient(Integer id) throws ResourceNotFoundException;
    void updatePatient(PatientDto patientDto) throws ResourceNotFoundException;
    String deletePatient(Integer id) throws ResourceNotFoundException;
    Set<PatientDto> getAllPatients();

}
