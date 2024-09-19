package runner.Execeptions;

public class UserIdAlreadyExists extends RuntimeException{
    public UserIdAlreadyExists (String message) {
        super(message);
    }
}
