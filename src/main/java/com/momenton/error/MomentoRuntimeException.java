package com.momenton.error;

import org.springframework.http.HttpStatus;

public class MomentoRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 6272749291937249710L;
	private HttpStatus httpStatus;

	public MomentoRuntimeException() {
		// Empty
	}

	public MomentoRuntimeException(final Throwable cause) {
		super(cause);
	}

	public MomentoRuntimeException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public MomentoRuntimeException(final String message) {
		super(message);
	}

	public MomentoRuntimeException(final String message, final HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public MomentoRuntimeException(final String message, final Throwable cause, final HttpStatus httpStatus) {
		super(message, cause);
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(final HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}