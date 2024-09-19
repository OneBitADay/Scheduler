package runner.Execeptions.userExceptions;

public class UserIdAlreadyExists extends RuntimeException{
    public UserIdAlreadyExists (String message) {
        super(message);
    }
}
