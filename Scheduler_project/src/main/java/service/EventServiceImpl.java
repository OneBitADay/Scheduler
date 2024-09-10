package service;

import model.Event;
import model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Override
    public Event createEvent(Event event) {
        return null;
    }

    @Override
    public Event createEvent(String eventType, String typeOfService, String nameOfEvent, String address, Date start, Date end, Person person) {
        return null;
    }

    @Override
    public List<Event> getEventsForPerson(String name, Date start, Date end) {
        return null;
    }

    @Override
    public List<Event> getEventsForDay(Date start) {
        return List.of();
    }

    @Override
    public List<Event> getEventsForPeriod(Date start, Date end) {
        return List.of();
    }

    @Override
    public Event getEventById(String id) {
        return null;
    }

    @Override
    public Event updateEvent(Event newEvent) {
        return null;
    }

    @Override
    public Event rescheduleEvent(Event event, Date start, Date end) {
        return null;
    }

    @Override
    public Event deleteEventById(String id) {
        return null;
    }

}
