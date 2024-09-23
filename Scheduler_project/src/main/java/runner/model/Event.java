package runner.model;

import jakarta.persistence.*;
import lombok.Data;
import runner.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Event is catorgarized as local event (wedding, birthday, get-together,etc) OR
 *
 */
@Data
@Entity
@Table(name = "event")
public class Event {
    enum EVENTTYPES {
        AWAYEVENT, //Services
        HOMEEVENT, //Place Rental
        BULKEVENT, // place and service rental
        PHOTOEVENT, // rental service at without renting space

    }

    enum TYPEOFSERVICE {

    }

    @Id
    @Column(name = "eventId")
    UUID eventId;

    @Column(name = "name_of_event", nullable = false)
    String nameOfEvent;

    @Column(name = "address", nullable = false)
    String address; // TODO should address be it's own class? Maybe Address class?

    @Column(name = "desc", nullable = true)
    String desc; // Description of event -- OPTIONAL?

    @Column(name = "date_start", nullable = false)
    Date dateStart; // date of starting DATE and TIME

    @Column(name = "date_end", nullable = false)
    Date dateEnd; // date of ending DATE and TIME


    @ManyToMany
    @CollectionTable(name = "event_attendees", joinColumns = @JoinColumn(name = "event_id"))
    @Column(name = "event_attendees", nullable = true)
    List<UserProfile> eventAttendees;


    public Event () {
        this.eventId = UUID.randomUUID();
    }

    public Event (String nameOfEvent, String address, String dateStart, String dateEnd) {
        this();
        this.nameOfEvent = nameOfEvent;
        this.address = address;
        this.dateStart = DateUtil.StringToDate(new SimpleDateFormat("MM/dd/yyyy H:mm a"),dateStart).orElse(null);
        this.dateEnd = DateUtil.StringToDate(new SimpleDateFormat("MM/dd/yyyy H:mm a"),dateEnd).orElse(null);
    }

    public Event (String nameOfEvent, String address, Date dateStart, Date dateEnd, String desc ) {
        this();
        this.nameOfEvent = nameOfEvent;
        this.address = address;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.desc = desc;
    }
    public Event (String nameOfEvent, String address, Date dateStart, Date dateEnd, String desc, List<UserProfile> eventAttendees) {
        this();
        this.nameOfEvent = nameOfEvent;
        this.address = address;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.desc = desc;
        getEventAttendees().addAll(eventAttendees);
    }


    public List<UserProfile> getEventAttendees() {
        if(this.eventAttendees == null) {
            this.eventAttendees = new ArrayList<>();
        }

        return this.eventAttendees;
    }
}
