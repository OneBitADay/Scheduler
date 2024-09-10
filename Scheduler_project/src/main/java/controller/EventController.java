package controller;

import model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.EventService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("events")
public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping("/{name} , produces = application/json")
    public List<Event> getEvents(@PathVariable String name, @RequestParam Date start, @RequestParam Date end) {
        return eventService.getEventsForPerson(name, start, end);
    }
}
