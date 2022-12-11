package com.managesystem.dentalclinic.service;

import com.managesystem.dentalclinic.entity.Dentist;
import com.managesystem.dentalclinic.entity.DentistDto;

import java.util.List;
import java.util.Set;

public interface IDentistService {

    void createDentist(DentistDto dentistDto);
    DentistDto readDentist(Integer id);
    void updateDentist(DentistDto dentistDto);
    void deleteDentist(Integer id);
    List<Dentist> findDentistByLastName(String lastName);
    Set<DentistDto> getAllDentists();

}
