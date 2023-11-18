package com.hotel.exception;

public class UnknownExceptions extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnknownExceptions(String message) {
        super(message);
    }
}