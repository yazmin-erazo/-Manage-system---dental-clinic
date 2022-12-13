package com.managesystem.dentalclinic.service;

import com.managesystem.dentalclinic.entity.Address;
import com.managesystem.dentalclinic.exception.ResourceNotFoundException;

import java.util.Optional;
import java.util.Set;

public interface IAddressService {

    void createAddress(Address address);
    Optional<Address> readAddress(Integer id) throws ResourceNotFoundException;
    void updateAddress(Address address) throws ResourceNotFoundException;
    void deleteAddress(Integer id) throws ResourceNotFoundException;
    Set<Address> getAllAddress();


}
