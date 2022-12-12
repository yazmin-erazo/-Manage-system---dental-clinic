package com.managesystem.dentalclinic.service;

import com.managesystem.dentalclinic.entity.Dentist;
import com.managesystem.dentalclinic.entity.DentistDto;
import com.managesystem.dentalclinic.exception.BadRequestException;
import com.managesystem.dentalclinic.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Set;

public interface IDentistService {

    void createDentist(DentistDto dentistDto);
    DentistDto readDentist(Integer id) throws ResourceNotFoundException, BadRequestException;
    void updateDentist(DentistDto dentistDto) throws ResourceNotFoundException;
    void deleteDentist(Integer id) throws ResourceNotFoundException;
    List<Dentist> findDentistByLastName(String lastName);
    Set<DentistDto> getAllDentists();

}
