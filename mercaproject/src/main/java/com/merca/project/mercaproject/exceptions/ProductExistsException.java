package com.merca.project.mercaproject.exceptions;

import jakarta.persistence.PersistenceException;

import java.io.Serial;

public class ProductExistsException extends PersistenceException{

	
	@Serial
	private static final long serialVersionUID = 2665287825112530476L;

	public ProductExistsException() {
		super("EAN alredy exists");
	}

}
