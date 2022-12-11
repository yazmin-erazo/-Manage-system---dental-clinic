package com.managesystem.dentalclinic.service.Imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.managesystem.dentalclinic.entity.Patient;
import com.managesystem.dentalclinic.entity.PatientDto;
import com.managesystem.dentalclinic.repository.IPatientRepository;
import com.managesystem.dentalclinic.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class PatientServiceImp implements IPatientService {

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    ObjectMapper mapper;

    public void save(PatientDto patientDto) {
        Patient patient = mapper.convertValue(patientDto, Patient.class);
        patientRepository.save(patient);
    }

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        LocalDate date = LocalDate.now();
        Patient patient = mapper.convertValue(patientDto, Patient.class);
        patient.setDateAdmition(date);
        patientRepository.save(patient);
        return patientDto;
    }

    @Override
    public PatientDto readPatient(Integer id) {
        Optional<Patient> patient = patientRepository.findById(id);
        PatientDto patientDto = null;
        if (patient.isPresent())
            patientDto = mapper.convertValue(patient, PatientDto.class);

        return patientDto;
    }

    @Override
    public void updatePatient(PatientDto patientDto) {
        save(patientDto);
    }

    @Override
    public String deletePatient(Integer id) {
        if(patientRepository.findById(id).isPresent()){
            patientRepository.deleteById(id);
            return "Paciente con id: " + id + " eliminado";
        }
        return "El Paciente con id: " + id + " no fue encontrado";
    }

    @Override
    public Set<PatientDto> getAllPatients() {
        
        List<Patient> patientList = patientRepository.findAll();
        Set<PatientDto> patientListDto = new HashSet<>(); 

        for ( Patient patient: patientList) {
            patientListDto.add(mapper.convertValue(patient, PatientDto.class));
        }        
        return patientListDto;
    }

    
}
