package br.com.hack.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ZipCodeException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionTO handleException(ZipCodeException ex) {
		return new ExceptionTO(ex.getMessage());
	}
	
	@ExceptionHandler(AddressException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionTO handleException(AddressException ex) {
		return new ExceptionTO(ex.getMessage());
	}
	
	@ExceptionHandler(AddressCreateException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public @ResponseBody ExceptionTO handleException(AddressCreateException ex) {
		return new ExceptionTO(ex.getMessage());
	}
	
}
