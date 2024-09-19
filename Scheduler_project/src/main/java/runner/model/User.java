package runner.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import runner.service.ArgonSingleton;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {

    //TODO: ADD A VARIABLE FOR LIST<EVENT> EVENTS;

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "fname", nullable = false)
    private String fname;

    @Column(name = "lname", nullable = false)
    private String lname;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "userid", nullable = false)
    private String userid;

    @Column(name = "password", nullable = false)
    private String password;

    //Examples on how to utilize date/timestamp in Postgre https://www.postgresql.org/docs/current/datatype-datetime.html
    @Column(name = "dob", nullable = false)
    private Date dob;//object for date of birth

    public transient String dobHolder;

    private transient int age;

    // Sample date 9/16/2024 4:51 PM
    private transient final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy H:mm a");

    public User() {}
    public User (String fname, String lname, String email, String userid, String dobHolder, String password) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.userid = userid;
        this.id = UUID.randomUUID();
        setDob(dobHolder);
        setPassword(password);
    }

    private int computeAge() {//takes a date obj from above
        return 0;
    }

    public void setPassword(String password) {
        this.password = ArgonSingleton.getInstance().encode(password);
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
