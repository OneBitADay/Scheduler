package runner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import runner.Execeptions.eventExceptions.EventAlreadyExists;
import runner.Execeptions.eventExceptions.EventIdProvidedisNull;
import runner.Execeptions.eventExceptions.EventNotFound;
import runner.model.Event;
import runner.model.User;
import runner.repository.EventRepository;
import runner.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Event persistEvent(Event event) {
        verificationProcess(event);
        if(event.getDesc() == null || event.getDesc().isEmpty()) {
            event.setDesc("Description not provided.");
        }

        User user = userRepository.findByUseruuid(event.getOwner());

        event.getEventAttendees().add(user);
        user.getEvents().add(event);

        eventRepository.save(event);
        userRepository.save(user);
        return event;
    }

    @Override
    public Event getEvent(UUID eventid) {
        if (eventid != null) {
            List<Event> events = eventRepository.findByEventId(eventid);
            if(events.isEmpty()) {
                throw new EventNotFound(String.format("Event with id %s not found", eventid));
            }
            else {
                return events.get(0);
            }
        }
        else {
            throw new EventIdProvidedisNull("EventId provided is null, please provide a valid eventId");
        }
    }

    @Override
    public Boolean updateEvent(UUID eventid, Event event) {
        List<Event> events = eventRepository.findByEventId(eventid);
        Event oldEvent = events.get(0);
        verificationProcess(oldEvent);


        if (!oldEvent.getNameOfEvent().equals(event.getNameOfEvent())) {
            oldEvent.setNameOfEvent(event.getNameOfEvent());
        }

        if (!oldEvent.getAddress().equals(event.getAddress())) {
            oldEvent.setAddress(event.getAddress());
        }

        if (!oldEvent.getDateStart().equals(event.getDateStart())) {
            oldEvent.setDateStart(event.getDateStart());
        }

        if (!oldEvent.getDateEnd().equals(event.getDateEnd())) {
            oldEvent.setDateEnd(event.getDateEnd());
        }

        if (!oldEvent.getDesc().equals(event.getDesc())) {
            oldEvent.setDesc(event.getDesc());
        }

        eventRepository.save(oldEvent);
        return true;
    }

    @Override
    public Boolean addAttendeesToEvent(UUID eventid, List<User> attendees) {
        List<Event> events = eventRepository.findByEventId(eventid);
        Event event = events.get(0);
        verificationProcess(event);

        event.getEventAttendees().addAll(attendees);
        eventRepository.save(event);
        return true;
    }

    @Override
    public boolean removeAttendeesFromEvent(UUID eventid, List<User> attendees) {
        List<Event> events = eventRepository.findByEventId(eventid);
        Event event = events.get(0);
        verificationProcess(event);

        event.getEventAttendees().removeAll(attendees);
        eventRepository.save(event);
        return true;
    }

    private boolean checckIfdEventIdExists(UUID eventId) {
        return !eventRepository.findByEventId(eventId).isEmpty();
    }

    private void verificationProcess(Event event) {
        if (checckIfdEventIdExists(event.getEventId())) {
            throw new EventAlreadyExists(String.format("Event with id %s already exists", event.getEventId()));
        }
    }
}
