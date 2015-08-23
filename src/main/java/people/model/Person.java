package people.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import org.springframework.format.annotation.DateTimeFormat;
import org.joda.time.DateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Type;


/**
 *  Person object
 *
 *  @author Marcus Turnbo
 */

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name = "firstname", length = 50)
    private String firstName;

    @Column(name = "lastname", length = 50)
    private String lastName;

    @Column(name = "birthdate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private DateTime birthDate;

    @ManyToOne(optional=true)
    // @JoinColumn(name = "FAMILY_ID", referencedColumnName="FAMILY_ID")
    private Family family;

    protected Person() {}

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Person[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
