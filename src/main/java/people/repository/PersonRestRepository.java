package people.repository;

import people.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *  Person REST respository
 *
 *  @author Marcus Turnbo
 *
 *  Allows various operations involving Person objects by extending the PagingAndSortingRepository interface
 */

@RepositoryRestResource(collectionResourceRel="person", path="person")
public interface PersonRestRepository extends PagingAndSortingRepository<Person, Long> {

    List<Person> findByFirstName(@Param("name") String firstName);
    List<Person> findByLastName(@Param("name") String lastName);
    List<Person> findByLastNameAndFirstName(@Param("firstname") String firstName, @Param("lastname") String lastName);
    List<Person> findByLastNameOrFirstName(@Param("firstname") String firstName, @Param("lastname") String lastName);
    List<Person> findByBirthDateGreaterThan(@Param("date") Date birthDate);

}
