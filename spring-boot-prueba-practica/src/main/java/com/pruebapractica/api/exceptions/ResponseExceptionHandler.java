package com.pruebapractica.api.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		RespuestaException respuestaException = new RespuestaException(new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<Object>(respuestaException, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request) {
		RespuestaException respuestaException = new RespuestaException(new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<Object>(respuestaException, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BadRequestException.class)
	public final ResponseEntity<Object> handleBadRequestException(BadRequestException ex, WebRequest request) {
		RespuestaException respuestaException = new RespuestaException(new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<Object>(respuestaException, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		RespuestaException respuestaException = new RespuestaException(new Date(), "Se produjo un error debido a los datos enviados",
				request.getDescription(false));

		return super.handleExceptionInternal(ex, respuestaException, headers, HttpStatus.BAD_REQUEST, request);
	}
}
