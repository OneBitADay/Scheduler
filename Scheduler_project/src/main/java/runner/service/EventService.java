package runner.service;

import runner.model.Event;
import runner.model.UserProfile;

import java.util.List;
import java.util.UUID;

public interface EventService  {
    Event persistEvent(Event event);
    Event getEvent(UUID eventid);

    Boolean updateEvent(UUID eventid, Event event);
    Boolean addAttendeesToEvent(UUID eventid, List<UserProfile> attendees);
    boolean removeAttendeesFromEvent(UUID eventid, List<UserProfile> attendees);
}
