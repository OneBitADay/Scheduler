package service;

import model.Event;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Override
    public List<Event> getEventsForPerson(String name, Date start, Date end) {
        return null;
    }

}
