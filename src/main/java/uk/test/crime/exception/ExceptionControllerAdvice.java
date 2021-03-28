package uk.test.crime.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.ServiceUnavailableException;
import javax.validation.ConstraintViolationException;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

	@ResponseStatus(NOT_FOUND)
	@ExceptionHandler({ DataNotFoundException.class})
	public ResponseEntity<Object> handleDataNotFoundException(Exception e) {
		logger.warn(e.getMessage(), e);
		return buildResponse(NOT_FOUND, e.getMessage());
	}

	
	@ExceptionHandler({ ServiceUnavailableException.class})
	public ResponseEntity<Object> serviceNotAvailable(Exception e) {
		logger.warn(e.getMessage(), e);
		return buildResponse(SERVICE_UNAVAILABLE, e.getMessage());
	}
	
	@ResponseStatus(BAD_REQUEST)
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolations(Exception e) {
		logger.warn(e.getMessage(), e);
		return buildResponse(BAD_REQUEST, e.getMessage());
	}

	
	
	
	protected ResponseEntity<Object> buildResponse(HttpStatus status, String message) {
		ErrorDetails error = new ErrorDetails();
		error.setStatus(status.value());
		error.setError(status.getReasonPhrase());
		error.setMessage(message);
		return new ResponseEntity<>(error, status);
	}
}
