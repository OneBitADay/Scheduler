package model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Event is catorgarized as local event (wedding, birthday, get-together,etc) OR
 *
 */
@Entity
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
    String id;

    String nameeOfEvent;

    String address; // TODO should address be it's own class? Maybe Address class?

    String desc; // Description of event -- OPTIONAL?

    Date dateStart; // date of starting DATE and TIME

    Date dateEnd; // date of ending DATE and TIME

    Person person; // The person scheduling the event (Use id instead?)
}
