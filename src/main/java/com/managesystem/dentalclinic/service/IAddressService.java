package com.managesystem.dentalclinic.service;

import com.managesystem.dentalclinic.entity.Address;

import java.util.Optional;
import java.util.Set;

public interface IAddressService {

    void createAddress(Address address);
    Optional<Address> readAddress(Integer id);
    void updateAddress(Address address);
    void deleteAddress(Integer id);
    Set<Address> getAllAddress();


}
