package peog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import peog.entities.Information;

import java.util.List;

@Repository
public interface InformationRepository extends CrudRepository<Information, Integer> {
    List<Information> findAll();
}
