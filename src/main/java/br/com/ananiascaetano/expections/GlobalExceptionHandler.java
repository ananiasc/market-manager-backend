package br.com.ananiascaetano.expections;

import br.com.ananiascaetano.constants.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException exception) {
        return new ResponseEntity<>(ErrorMessages.AUTHENTICATION_FAIL, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(UsernameAlreadyExistException.class)
    public ResponseEntity<String> handleUserLoginAlreadyExistException(UsernameAlreadyExistException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
