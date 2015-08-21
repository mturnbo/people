package people.model;

import javax.persistence.Id;
import java.util.Collection;

public class Family {

    @Id
    private Long id;

    private String name;
    private Collection persons;
}
