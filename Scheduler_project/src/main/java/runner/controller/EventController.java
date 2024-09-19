package runner.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EventController {


    /**
     * GET:
     *      /event/{eventid} -- returns event by id
     *      /events -- returns all events
     *      /event/{userid} -- returns events of a given user
     * DELETE
     *      /event/eventid -- remove event and from any user involved
     * POST
     *      /event -- create event
     *      /events -- create a bulk of events
     * PUT
     *      /event -- edit event name, location, type and details, time start, time end
     */
}
