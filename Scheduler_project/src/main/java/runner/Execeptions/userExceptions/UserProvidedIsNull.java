package runner.Execeptions.userExceptions;

public class UserProvidedIsNull extends RuntimeException {

    public UserProvidedIsNull (String message) {
        super(message);
    }
}
