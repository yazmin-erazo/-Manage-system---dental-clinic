package com.managesystem.dentalclinic.controller;

import com.managesystem.dentalclinic.entity.Dentist;
import com.managesystem.dentalclinic.entity.DentistDto;
import com.managesystem.dentalclinic.exception.BadRequestException;
import com.managesystem.dentalclinic.exception.ResourceNotFoundException;
import com.managesystem.dentalclinic.service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    @Autowired
    private IDentistService dentistService;

    @PostMapping("/create")
    public ResponseEntity<?> createDentist(@RequestBody DentistDto dentistDto){
        dentistService.createDentist(dentistDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public DentistDto getDentist(@PathVariable Integer id) throws ResourceNotFoundException, BadRequestException {
        return dentistService.readDentist(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> modifyDentist(@RequestBody DentistDto dentistDto) throws ResourceNotFoundException {
        dentistService.updateDentist(dentistDto);
        return ResponseEntity.ok("Odontólogo actualizado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeDentist(@PathVariable Integer id) throws ResourceNotFoundException {
        dentistService.deleteDentist(id);
        return ResponseEntity.ok("Odontólogo eliminado");
    }

    @GetMapping("getByLastName/{lastName}")
    public ResponseEntity<List<Dentist>> dentistlastName (@PathVariable String lastName){
        List<Dentist> dentist = dentistService.findDentistByLastName(lastName);
        if(dentist != null){
            return ResponseEntity.ok(dentist);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/list")
    public Collection<DentistDto> getAllPatients(){
        return dentistService.getAllDentists();
    }

}
