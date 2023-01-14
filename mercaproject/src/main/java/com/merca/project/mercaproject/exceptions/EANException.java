package com.merca.project.mercaproject.exceptions;

import jakarta.persistence.PersistenceException;

import java.io.Serial;

public class EANException extends PersistenceException {


	@Serial
	private static final long serialVersionUID = 811903171167977937L;

	public EANException() {
		super();
	}

	public EANException(String message) {
		super(message);
	}
}
