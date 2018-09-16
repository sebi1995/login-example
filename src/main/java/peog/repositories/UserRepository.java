package peog.repositories;

import org.springframework.data.repository.CrudRepository;
import peog.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findUserByUsername(String username);
}
