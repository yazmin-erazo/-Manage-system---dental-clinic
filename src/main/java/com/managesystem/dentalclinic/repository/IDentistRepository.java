package com.managesystem.dentalclinic.repository;

import com.managesystem.dentalclinic.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Integer> {

    // TODO Con HQL
    @Query("FROM Dentist d WHERE d.lastName like %:lastName%")
    List<Dentist> findByLastName(String lastName);

    //TODO Con Optional
    @Query("FROM Dentist d WHERE d.firstName like %:firstName%")
    Optional<Dentist> findByFirstName(String firstName);

}
