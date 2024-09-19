package runner.Execeptions;

public class UserAlreadyExists extends RuntimeException {

    public UserAlreadyExists (String message) {
        super(message);
    }
}
