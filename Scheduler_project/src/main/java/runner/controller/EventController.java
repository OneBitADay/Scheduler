package runner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import runner.model.Event;
import runner.model.User;
import runner.service.EventService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    EventService eventService;

    /**
     * GET:
     *      /event/{eventId} -- returns event by id
     *      /events -- returns all events
     *      /event/{eventId}/users -- returns events of a given user
     * DELETE
     *      /event/{eventId} -- remove event and from any user involved
     *      /event/{eventId}/{userId} -- remove attendee(s) from event
     * POST
     *      /event -- create event
     *      /events -- create a bulk of events
     * PUT
     *      /event -- edit event name, location, type and details, time start, time end
     *      /event/addAttendees -- append users that'll be attending event
     *      /event/removeAttendees -- remove users that'll be attending event
     */


    @GetMapping("/event")
    public ResponseEntity<List<Event>> getEvents(@PathVariable UUID eventId) {
        return null;
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<Event> getEvent(@PathVariable UUID eventId) {
        return null;
    }

    @GetMapping("/event/{eventId}/users")
    public ResponseEntity<Event> getAllAttendeesForEvent(@PathVariable String eventId) {
        return null;
    }

    @DeleteMapping("/event/{eventId}")
    public ResponseEntity<Boolean> purgeEvent(@PathVariable UUID eventId) {
        return null;
    }

    @DeleteMapping("/event/{eventId}/{userId}")
    public ResponseEntity<Boolean> purgeAttendeeAtEvent(@PathVariable UUID eventId, @PathVariable String userId) {
        return null;
    }

    @PostMapping("/event")
    public ResponseEntity<Event> persistEvent(@RequestBody Event event) {
        eventService.persistEvent(event);
        return null;
    }

    @PutMapping("/event")
    public ResponseEntity<Event> updateEvent (@RequestBody Event event) {
        return null;
    }

    @PutMapping("/event/addAttendees")
    public ResponseEntity<Boolean> addAttendeesToEvent(@RequestBody UUID eventId, @RequestBody List<User> attendees) {
        return null;
    }

    @PutMapping("/event/removeAttendees")
    public ResponseEntity<Boolean> removeAttendeesFromEvent(@RequestBody UUID eventId, @RequestBody List<User> attendees) {
        return null;
    }
}
