package me.team.usercrud.user.infrastructure.controllers.handlers;

import me.team.usercrud.shared.domain.exceptions.NullArgumentException;
import me.team.usercrud.user.application.exceptions.IllegalCriteriaArgumentsException;
import me.team.usercrud.user.application.exceptions.UserAlreadyExistsException;
import me.team.usercrud.user.application.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> handleGeneralException(Exception ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
            ex.getMessage());
        return new ResponseEntity<>(problemDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleUserNotFoundException(UserNotFoundException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(problemDetail, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ProblemDetail> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, ex.getMessage());
        return new ResponseEntity<>(problemDetail, HttpStatus.CONFLICT);
    }
    
    @ExceptionHandler(IllegalCriteriaArgumentsException.class)
    public ResponseEntity<ProblemDetail> handleCriteriaException(IllegalCriteriaArgumentsException ex) {
        System.out.println("!Caught!");
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(problemDetail, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(NullArgumentException.class)
    public ResponseEntity<ProblemDetail> handleCriteriaException(NullArgumentException ex) {
        System.out.println("!Caught!");
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        
        ex.field().ifPresent(field -> {
            problemDetail.setProperty("field", field);
        });
        
        return new ResponseEntity<>(problemDetail, HttpStatus.BAD_REQUEST);
    }
}
