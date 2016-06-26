package br.com.hack.rest.exception;

import java.io.Serializable;

public class ExceptionTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;

	public ExceptionTO(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}