package com.hotel.exception;

public class KnownExceptions extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public KnownExceptions(String message) {
        super(message);
    }
}