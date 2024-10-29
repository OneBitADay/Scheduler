package runner.service;

import runner.model.Event;
import runner.model.User;

import java.util.List;
import java.util.UUID;

public interface EventService  {
    Event persistEvent(Event event);
    Event getEvent(UUID eventid);

    Boolean updateEvent(UUID eventid, Event event);
    Boolean addAttendeesToEvent(UUID eventid, List<User> attendees);
    boolean removeAttendeesFromEvent(UUID eventid, List<User> attendees);
}
