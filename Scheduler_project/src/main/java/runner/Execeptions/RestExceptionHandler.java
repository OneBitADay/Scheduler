package runner.Execeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserIdAlreadyExists.class)
    protected ResponseEntity<Object> handleUserIdAlreadyExists(UserIdAlreadyExists ex) {
        ApiError apiError = new ApiError(HttpStatus.FOUND);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(UserAlreadyExists.class)
    protected ResponseEntity<Object> handleUserAlreadyExists(UserAlreadyExists ex) {
        ApiError apiError = new ApiError(HttpStatus.FOUND);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(UserProvidedIsNull.class)
    protected ResponseEntity<Object> handleUserProvidedIsNull(UserProvidedIsNull ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(UserNotFound.class)
    protected ResponseEntity<Object> handleUserNotFound(UserNotFound ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(FailedToRemoveUser.class)
    protected ResponseEntity<Object> handleFailedToRemoveUser(FailedToRemoveUser ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(UserPasswordIdentical.class)
    protected ResponseEntity<Object> handleUserPasswordIdentical(UserPasswordIdentical ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
