package com.africafuture.recipe.exception;

import lombok.Getter;

@Getter
public class BaseEndPointException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String errorKey;
	private final Object[] params;
	private final String defaultMessage;

	public BaseEndPointException(String errorKey, String defaultMessage, Object... params) {
		super(defaultMessage);
		this.errorKey = errorKey;
		this.params = params;
		this.defaultMessage = defaultMessage;
	}
}
