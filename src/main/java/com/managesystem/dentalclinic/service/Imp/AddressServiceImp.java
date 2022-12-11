package com.managesystem.dentalclinic.service.Imp;

import com.managesystem.dentalclinic.entity.Address;
import com.managesystem.dentalclinic.repository.IAddressRepository;
import com.managesystem.dentalclinic.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AddressServiceImp implements IAddressService {

    @Autowired
    private IAddressRepository addressRepository;


    @Override
    public void createAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public Optional<Address> readAddress(Integer id) {
        Optional<Address> address = addressRepository.findById(id);
        return address;
    }

    @Override
    public void updateAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Integer id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Set<Address> getAllAddress() {
        List<Address> allAddress = addressRepository.findAll();
        return new HashSet<>(allAddress);
    }


 /*   @Override
    public Set<Address> getAllAddress() {
        List<Address> allAddress = addressRepository.findAll();
        Set<Address> addressList = new HashSet<>(allAddress);
        return addressList;
    }*/


}
