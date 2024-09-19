package runner.Execeptions;

public class UserProvidedIsNull extends RuntimeException {

    public UserProvidedIsNull (String message) {
        super(message);
    }
}
