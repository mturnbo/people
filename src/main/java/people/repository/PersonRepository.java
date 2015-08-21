package people.repository;

import people.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="people", path="people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    List<Person> findByFirstName(@Param("name") String firstName);
    List<Person> findByLastName(@Param("name") String lastName);

}
