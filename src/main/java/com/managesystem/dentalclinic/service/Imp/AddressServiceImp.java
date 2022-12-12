package com.managesystem.dentalclinic.service.Imp;

import com.managesystem.dentalclinic.entity.Address;
import com.managesystem.dentalclinic.entity.AppointmentDto;
import com.managesystem.dentalclinic.exception.ResourceNotFoundException;
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
    public Optional<Address> readAddress(Integer id) throws ResourceNotFoundException {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isEmpty())
            throw new ResourceNotFoundException("La dirección con id " + id + " no fue encontrada");
        return address;
    }

    @Override
    public void updateAddress(Address address) throws ResourceNotFoundException {
        if (addressRepository.findById(address.getId()).isEmpty())
            throw new ResourceNotFoundException("No existe la dirección con id: " + address.getId());
        addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Integer id) throws ResourceNotFoundException {
        if(addressRepository.findById(id).isEmpty())
            throw new ResourceNotFoundException("No existe una dirección con id: " + id);
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
