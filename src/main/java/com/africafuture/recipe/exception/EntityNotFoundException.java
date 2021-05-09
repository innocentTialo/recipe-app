package com.africafuture.recipe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends BaseEndPointException {
	public EntityNotFoundException(String errorKey, String defaultMessage, Object... params) {
		super(errorKey, defaultMessage, params);
	}
}
