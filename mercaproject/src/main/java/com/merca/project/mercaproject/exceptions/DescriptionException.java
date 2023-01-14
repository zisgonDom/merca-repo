package com.merca.project.mercaproject.exceptions;

import jakarta.persistence.PersistenceException;

import java.io.Serial;

public class DescriptionException extends PersistenceException {

	
	@Serial
	private static final long serialVersionUID = -2175552529228369332L;

	public DescriptionException() {
		super();
	}

	public DescriptionException(String message) {
		super(message);
	}
}
