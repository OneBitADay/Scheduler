package runner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import runner.model.Event;
import runner.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {


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
     *      /event -- append or remove users that'll be attending event
     */


    @Autowired
    EventService eventService;

    @GetMapping("/event")
    public ResponseEntity<List<Event>> getEvents(@PathVariable String eventId) {
        return null;
    }
    @GetMapping("/event/{eventId}")
    public ResponseEntity<Event> getEvent(@PathVariable String eventId) {
        return null;
    }
    @GetMapping("/event/{eventId}/users")
    public ResponseEntity<Event> getAllAttendeesForEvent(@PathVariable String eventId) {
        return null;
    }

    @DeleteMapping("/event/{eventId}")
    public ResponseEntity<Boolean> purgeEvent(@PathVariable String eventId) {
        return null;
    }
    @DeleteMapping("/event/{eventId}/{userId}")
    public ResponseEntity<Boolean> purgeAttendeeAtEvent(@PathVariable String eventId, @PathVariable String userId) {
        return null;
    }

    @PostMapping("/event")
    public ResponseEntity<Event> purgeEvent(@RequestBody Event event) {
        return null;
    }

    @PutMapping("/event")
    public ResponseEntity<Event> updateEvent (@RequestBody Event event) {
        return null;
    }
}
