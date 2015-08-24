package people.repository;

import org.springframework.data.repository.CrudRepository;
import people.model.Person;

public interface PersonRepositoryCrud extends CrudRepository<Person, Long> {

}