package runner.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    UUID id;

    @Column(name = "name_of_event", nullable = false)
    String nameeOfEvent;

    String address; // TODO should address be it's own class? Maybe Address class?

    String desc; // Description of event -- OPTIONAL?

    Date dateStart; // date of starting DATE and TIME

    Date dateEnd; // date of ending DATE and TIME

    List<User> eventAttendees;
}
