package runner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;
import runner.service.ArgonSingleton;
import runner.util.DateUtil;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;



@Entity
@Data
@Table(name = "users")
public class User implements Serializable {
    @Id
    @UuidGenerator
    @Column(name="useruuid")
    private UUID useruuid;

    private String firstName;
    private String lastName;
    private String email;
    private String userId;

    //Examples on how to utilize date/timestamp in Postgre https://www.postgresql.org/docs/current/datatype-datetime.html
    private LocalDate dateOfBirth;


    @Column(name = "password", nullable = false)
    private String password;

    private transient String dobHolder;

    @Column(name = "aboutme")
    private String desc;

    private transient int age;

    @ManyToMany
    @Column(name = "list_of_events")
    @CollectionTable(name = "list_of_events", joinColumns = @JoinColumn(name = "userUUID"))
    private List<Event> events;

    public User() {

    }

    private void setPassword(String password) {
        this.password = ArgonSingleton.getInstance().encode(password);
    }

//    public void setDateOfBirth(String date) {
//        this.setDateOfBirth(DateUtil.StringToDate(
//                DateTimeFormatter.ofPattern("MM/dd/yyyy"),
//                DateTimeFormatter.ofPattern("MM/dd/yyyy"),
//                date).orElse(null));
//    }

    public String getPassword() {
        return password;
    }

    public String getDobHolder() {
        return dobHolder;
    }

    public void setDobHolder(String dobHolder) {
        this.dobHolder = dobHolder;
    }
}
