package peog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peog.entities.Address;
import peog.entities.User;
import peog.repositories.AddressRepository;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(Address address){
        return addressRepository.save(address);
    }

    public Address getAddressById(int id){
        return addressRepository.findById(id).get();
    }

    public Address getAddressByUser(User user){
        return addressRepository.findAddressByUser(user);
    }

    public Address getAddressByCountry(String country){
        return addressRepository.findAddressByCountry(country);
    }

    public void updateAddress(Address address){
        addressRepository.save(address);
    }

    public void deleteAddress(Address address){
        addressRepository.delete(address);
    }
}
