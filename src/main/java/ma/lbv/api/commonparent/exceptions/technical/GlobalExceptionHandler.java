package ma.lbv.api.commonparent.exceptions.technical;

import ma.lbv.api.commonparent.exceptions.response.ErrorResponse;
import ma.lbv.api.commonparent.exceptions.response.ValidationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleObjectNotFoundException(ObjectNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse("404", HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ObjectAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleObjectAlreadyExistException(ObjectAlreadyExistException ex) {
        ErrorResponse errorResponse = new ErrorResponse("409", HttpStatus.CONFLICT, ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    // Add more exception handlers for other custom exceptions

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        List<ValidationResponse> validationResponses = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            ValidationResponse validationResponse = new ValidationResponse(
                    error.getObjectName(),
                    error.getField(),
                    error.getRejectedValue(),
                    error.getDefaultMessage()
            );
            validationResponses.add(validationResponse);
        });

        List<String> validationErrors = validationResponses.stream()
                .map(validationResponse -> validationResponse.getField() + " : " + validationResponse.getMessage())
                .collect(Collectors.toList());

        ErrorResponse errorResponse = new ErrorResponse("400", HttpStatus.BAD_REQUEST, "Validation error");
        errorResponse.setParameters(validationErrors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Add more exception handlers for other validation-related exceptions

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse("500", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Add more exception handlers for other generic exceptions

}
