package com.price.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorException extends Exception {

	private static final long serialVersionUID = 1L;

	public ErrorException(String msg) {
		super(msg);
	}
	public ErrorException() {
		super("Datos de consulta incorrectos");
	}
}
