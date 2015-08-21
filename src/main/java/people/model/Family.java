package people.model;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "FAMILY")
public class Family {

    @Id
    @Column(name = "FAMILY_ID", nullable = false)
    private Long id;

    @Column(name = "NAME", length = 50)
    private String name;

    @OneToMany(mappedBy = "family", targetEntity = Person.class, fetch = FetchType.LAZY)
    private Collection people;

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

    @Override
    public String toString() {
        return String.format(
                "Family[id=%d, name='%s', count=%d]",
                id, name, people.size());
    }
}
