package runner.model;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.Service;
import org.hibernate.annotations.UuidGenerator;
import runner.util.DateUtil;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Event is catorgarized as local event (wedding, birthday, get-together,etc) OR
 *
 */
@Data
@Entity
@Table(name = "event")
public class Event implements Serializable {
    enum EVENTTYPES {
        AWAYEVENT, //Services
        HOMEEVENT, //Place Rental
        BULKEVENT, // place and service rental
        PHOTOEVENT, // rental service at without renting space

    }

    enum TYPEOFSERVICE {

    }

    @Id
    @UuidGenerator
    @Column(name = "event_id")
    private UUID eventId;

    @Column(name = "name_of_event", nullable = false)
    private String nameOfEvent;

    @Column(name = "address", nullable = false)
    private String address; // TODO should address be it's own class? Maybe Address class?

    @Column(name = "about")
    private String desc; // Description of event -- OPTIONAL?

    @Column(name = "date_start", nullable = false)
    private LocalDate dateStart; // date of starting DATE and TIME

    @Column(name = "date_end", nullable = false)
    private LocalDate dateEnd; // date of ending DATE and TIME

    @Column(name = "type_of_event", nullable = false)
    private String typeOfEvent;

    @Column(name = "type_of_service", nullable = false)
    private String typeOfService;

    @Column(name = "owner", nullable = false)
    private UUID owner;




    @ManyToMany
    @CollectionTable(name = "event_attendees", joinColumns = @JoinColumn(name = "event_id"))
    @Column(name = "event_attendees", nullable = true)
    Set<User> eventAttendees;


    public Event () {
    }

    public Event (String nameOfEvent, String address, String dateStart, String dateEnd) {
        this();
        this.nameOfEvent = nameOfEvent;
        this.address = address;
        this.dateStart = DateUtil.StringToDate(
                DateTimeFormatter.ofPattern("MM/dd/yyyy H:mm a"),
                DateTimeFormatter.ofPattern("MM/dd/yyyy H:mm a"),
                dateStart).orElse(null);
        this.dateEnd = DateUtil.StringToDate(
                DateTimeFormatter.ofPattern("MM/dd/yyyy H:mm a"),
                DateTimeFormatter.ofPattern("MM/dd/yyyy H:mm a"),
                dateEnd).orElse(null);
    }

    public Event (String nameOfEvent, String address, LocalDate dateStart, LocalDate dateEnd, String desc ) {
        this();
        this.nameOfEvent = nameOfEvent;
        this.address = address;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.desc = desc;
    }
    public Event (String nameOfEvent, String address, LocalDate dateStart, LocalDate dateEnd, String desc, List<User> eventAttendees) {
        this();
        this.nameOfEvent = nameOfEvent;
        this.address = address;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.desc = desc;
        getEventAttendees().addAll(eventAttendees);
    }


    public Set<User> getEventAttendees() {
        if(this.eventAttendees == null) {
            this.eventAttendees = new HashSet<>();
        }

        return this.eventAttendees;
    }
}
