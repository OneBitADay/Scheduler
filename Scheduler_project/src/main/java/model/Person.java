package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Person {
    @Id
    String id;

    String fname;
    String lname;
    String email;

    //object for date of birth

    int age;

    @OneToMany
    List<Event> events;

    private int computeAge() {//takes a date obj from above
        return 0;
    }
}
