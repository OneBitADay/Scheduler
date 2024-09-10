package service;

import model.Event;

import java.util.Date;
import java.util.List;

public interface EventService {

    Event createEvent(Event event);

    Event createEvent(enum eventType, enum typeOfService, String nameOfEvent, String address, Date start, Date end, Person person);

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    List<Event> getEventsForPerson(String name, Date start, Date end);

    /**
     * Returns a list of events that start on the given day.
     * @param start
     * @return
     */
    List<Event> getEventsForDay(Date start);

    List<Event> getEventsForPeriod(Date start, Date end);

    Event getEventById(String id);
    //////////////////////////////////////////////////////////////////////////////////////////////////////

    Event updateEvent(Event newEvent);

    Event rescheduleEvent(Event event, date start, Date end);

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    Event deleteEventById(String id);

}
