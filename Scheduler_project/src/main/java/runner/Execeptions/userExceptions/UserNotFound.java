package runner.Execeptions.userExceptions;

public class UserNotFound extends RuntimeException{
    public UserNotFound (String message) {
        super(message);
    }
}