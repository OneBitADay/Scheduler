package service;

import model.Event;

import java.util.Date;
import java.util.List;

public interface EventService {

    List<Event> getEventsForPerson(String name, Date start, Date end);
}
