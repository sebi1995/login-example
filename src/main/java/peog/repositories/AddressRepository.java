package peog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import peog.entities.Address;
import peog.entities.User;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
    Address findAddressByUser(User user);

    Address findAddressByCountry(String country);
}
