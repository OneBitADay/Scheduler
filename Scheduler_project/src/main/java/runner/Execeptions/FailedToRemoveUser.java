package runner.Execeptions;

public class FailedToRemoveUser extends RuntimeException{

    public FailedToRemoveUser(String message) {
        super(message);
    }
}
