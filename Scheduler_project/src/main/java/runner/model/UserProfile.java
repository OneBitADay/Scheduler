package runner.model;

import jakarta.persistence.*;
import lombok.Data;
import runner.service.ArgonSingleton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users_profile")
@SecondaryTable(name = "users", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class UserProfile {

    @Id
    @Column(name = "id", table = "users")
    private UUID id;

    @Column(name = "fname", table = "users")
    private String fname;

    @Column(name = "lname", table = "users")
    private String lname;

    @Column(name = "email", table = "users")
    private String email;

    @Column(name = "desc")
    private String desc;

    @Column(name = "age")
    private int age;

    @Column(name = "list_of_events")
    @ElementCollection
    @CollectionTable(name = "list_of_events", joinColumns = @JoinColumn(name = "id"))
    private List<Event> listOfEvents;

    //Examples on how to utilize date/timestamp in Postgre https://www.postgresql.org/docs/current/datatype-datetime.html
    @Column(name = "dob", table = "users")
    private Date dob;//object for date of birth

    public transient String dobHolder;

    // Sample date 9/16/2024 4:51 PM
    // TODO: remove the time from birth of date formatter
    private transient final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    public UserProfile() {}
    public UserProfile (String fname, String lname, String email, String dobHolder) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.id = UUID.randomUUID();
        setDob(dobHolder);
    }

    private int computeAge() {//takes a date obj from above
        return 0;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    private void setDob(String date) {

        Date retDate = null;
        try {
            retDate = this.sdf.parse(date);
        }catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.dob = retDate;
    }
}
