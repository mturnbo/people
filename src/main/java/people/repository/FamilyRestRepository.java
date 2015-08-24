package people.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import people.model.Family;
import java.util.List;

/**
 *  Family repository
 *
 *  @author Marcus Turnbo
 *
 *  Allows various operations involving Family objects by extending the PagingAndSortingRepository interface
 */

@RepositoryRestResource(collectionResourceRel="family", path="family")
public interface FamilyRestRepository extends PagingAndSortingRepository<Family, Long> {

    List<Family> findByName(@Param("name") String name);

}