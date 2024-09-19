package runner.service;

import runner.model.Event;

public interface EventService  {
    Event persistEvent(Event event);
    Event getEvent(String eventid);
}
