package people.repository;

import org.springframework.data.repository.CrudRepository;
import people.model.Family;

public interface FamilyRepositoryCrud extends CrudRepository<Family, Long> {

}