package com.banco.exception;

public class SaqueInvalidoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public SaqueInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public SaqueInvalidoException(String message) {
		super(message);
	}
	
}
