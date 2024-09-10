package service;

import model.Event;
import model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl  implements PersonService{


    @Override
    public Person createPerson(Person person) {
        return null;
    }

    @Override
    public Person createPerson(String fname, String lname, String email, int age) {
        return null;
    }

    @Override
    public Person getPerson(String name) {
        return null;
    }

    @Override
    public Person getPersonById(String id) {
        return null;
    }

    @Override
    public List<Event> getEventsForPersonById(String id) {
        return List.of();
    }

    @Override
    public Person updatePerson(String id, Person person) {
        return null;
    }

    @Override
    public Person newEventForPerson(String personId, Event event) {
        return null;
    }

    @Override
    public Person deletePerson(String id) {
        return null;
    }
}
