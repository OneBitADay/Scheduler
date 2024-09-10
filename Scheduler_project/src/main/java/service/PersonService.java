package service;

import model.Event;
import model.Person;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);

    Person createPerson(String fname, String lname, String email, int age);

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    Person getPerson(String name);

    Person getPersonById(String id);

    List<Event> getEventsForPersonById(String id);

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    Person updatePerson(String id, Person person);

    /**
     * Checks if the person has any events and adds the new one to the list.
     * If the person doesn't have any events create a new list to add it to.
     * @param personId
     * @param event
     * @return
     */
    Person newEventForPerson(String personId, Event event);

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    Person deletePerson(String id);
}
