package people.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import java.util.HashSet;
import java.util.Set;

/**
 *  Family object
 *
 *  @author Marcus Turnbo
 *
 *  Persisted object with one-to-many relationship with Person object
 */

@Entity()
@Table(name = "family")
public class Family {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @OneToMany(mappedBy = "family", targetEntity = Person.class, fetch = FetchType.EAGER)
    private Set<Person> people = new HashSet<>();

    protected Family() {}

    public Family(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Person> getPeople() {
        return this.people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    @Override
    public String toString() {
        return String.format(
                "Family[id=%d, name='%s', count=%d]",
                id, name, people.size());
    }
}
