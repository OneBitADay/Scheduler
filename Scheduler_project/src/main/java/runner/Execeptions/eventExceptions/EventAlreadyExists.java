package runner.Execeptions.eventExceptions;

public class EventAlreadyExists extends RuntimeException {

    public EventAlreadyExists(String message) {
        super(message);
    }
}
