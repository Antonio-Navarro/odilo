package com.antoniojnavarro.odilo.services.exceptions;

public class ServicioException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ServicioException() {
		super();
	}

	public ServicioException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServicioException(String message) {
		super(message);
	}
}
