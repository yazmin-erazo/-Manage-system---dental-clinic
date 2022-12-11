package com.managesystem.dentalclinic.controller;

import com.managesystem.dentalclinic.entity.Dentist;
import com.managesystem.dentalclinic.entity.DentistDto;
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

    @PostMapping
    public ResponseEntity<?> createDentist(@RequestBody DentistDto dentistDto){
        dentistService.createDentist(dentistDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DentistDto getDentist(@PathVariable Integer id){
        return dentistService.readDentist(id);
    }

    @PutMapping
    public ResponseEntity<?> modifyDentist(@RequestBody DentistDto dentistDto){
        dentistService.updateDentist(dentistDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeDentist(@PathVariable Integer id){
        dentistService.deleteDentist(id);
        return ResponseEntity.ok(HttpStatus.OK);
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

    @GetMapping
    public Collection<DentistDto> getAllPatients(){
        return dentistService.getAllDentists();
    }

}
