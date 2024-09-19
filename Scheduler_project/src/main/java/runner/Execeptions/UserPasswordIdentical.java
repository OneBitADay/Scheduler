package runner.Execeptions;

public class UserPasswordIdentical extends RuntimeException {
    public UserPasswordIdentical (String message) {
        super(message);
    }

}
