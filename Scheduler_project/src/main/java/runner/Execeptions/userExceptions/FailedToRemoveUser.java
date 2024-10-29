package runner.Execeptions.userExceptions;

public class FailedToRemoveUser extends RuntimeException{

    public FailedToRemoveUser(String message) {
        super(message);
    }
}
