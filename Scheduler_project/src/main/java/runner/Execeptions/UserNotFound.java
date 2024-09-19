package runner.Execeptions;

public class UserNotFound extends RuntimeException{
    public UserNotFound (String message) {
        super(message);
    }
}
