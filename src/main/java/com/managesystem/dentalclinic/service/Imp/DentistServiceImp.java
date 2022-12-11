package com.managesystem.dentalclinic.service.Imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.managesystem.dentalclinic.entity.Dentist;
import com.managesystem.dentalclinic.entity.DentistDto;
import com.managesystem.dentalclinic.repository.IDentistRepository;
import com.managesystem.dentalclinic.service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DentistServiceImp implements IDentistService {

    @Autowired
    private IDentistRepository dentistRepository;

    // Convierte los DTO en la clase de negocio
    @Autowired
    ObjectMapper mapper;

    public void save(DentistDto dentistDto) {
        Dentist dentist = mapper.convertValue(dentistDto, Dentist.class);
        dentistRepository.save(dentist);
    }

    @Override
    public void createDentist(DentistDto dentistDto) {
        save(dentistDto);
    }

    @Override
    public DentistDto readDentist(Integer id) {
        Optional<Dentist> dentist = dentistRepository.findById(id);
        DentistDto dentistDto = null;

        if (dentist.isPresent())
            dentistDto = mapper.convertValue(dentist, DentistDto.class);

        return dentistDto;
    }

    @Override
    public void updateDentist(DentistDto dentistDto) {
        save(dentistDto);
    }

    @Override
    public void deleteDentist(Integer id) {
        if(dentistRepository.findById(id).isPresent())
            dentistRepository.deleteById(id);
    }

    public List<Dentist> findDentistByLastName(String lastName) {
        return dentistRepository.findByLastName(lastName);
    }

    public Dentist findDentistByFirstName(String firstName) {
        return dentistRepository.findByFirstName(firstName).get();
    }

    @Override
    public Set<DentistDto> getAllDentists() {
        List<Dentist> dentistList = dentistRepository.findAll();
        Set<DentistDto> dentistDto =new HashSet<>();

        for (Dentist dentist: dentistList ) {
            dentistDto.add(mapper.convertValue(dentist, DentistDto.class));
        }

        return dentistDto;
    }


}
