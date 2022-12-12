package com.managesystem.dentalclinic.service.Imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.managesystem.dentalclinic.entity.Dentist;
import com.managesystem.dentalclinic.entity.DentistDto;
import com.managesystem.dentalclinic.exception.BadRequestException;
import com.managesystem.dentalclinic.exception.ResourceNotFoundException;
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


    @Autowired // Convierte los DTO en la clase de negocio
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
    public DentistDto readDentist(Integer id) throws ResourceNotFoundException, BadRequestException{
        Optional<Dentist> dentist = dentistRepository.findById(id);
        DentistDto dentistDto = null;
        if (dentist.isEmpty())
            throw new ResourceNotFoundException("El odontólogo con id " + id + " no fue encontrado");
        else if (!dentistRepository.existsById(id)) {
            throw new BadRequestException("El odontologo no existe");
        } else
            dentistDto = mapper.convertValue(dentist, DentistDto.class);

        return dentistDto;
    }

    @Override
    public void updateDentist(DentistDto dentistDto) throws ResourceNotFoundException {
        if (dentistRepository.findById(dentistDto.getId()).isEmpty())
            throw new ResourceNotFoundException("No existe el odontólogo con id: " + dentistDto.getId());
        save(dentistDto);
    }

    @Override
    public void deleteDentist(Integer id) throws ResourceNotFoundException {
        if(dentistRepository.findById(id).isEmpty())
            throw new ResourceNotFoundException("No existe un odontólogo con id: " + id);
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
