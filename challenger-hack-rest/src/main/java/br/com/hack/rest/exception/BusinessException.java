package br.com.hack.rest.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -1713673801697227018L;

	private final String message;

	public BusinessException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
