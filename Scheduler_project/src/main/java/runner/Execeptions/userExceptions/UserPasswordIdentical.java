package runner.Execeptions.userExceptions;

public class UserPasswordIdentical extends RuntimeException {
    public UserPasswordIdentical (String message) {
        super(message);
    }

}
