package com.managesystem.dentalclinic.service;

import com.managesystem.dentalclinic.entity.PatientDto;

import java.util.Set;

public interface IPatientService {
    PatientDto createPatient(PatientDto patientDto);
    PatientDto readPatient(Integer id);
    void updatePatient(PatientDto patientDto);
    String deletePatient(Integer id);
    Set<PatientDto> getAllPatients();

}
