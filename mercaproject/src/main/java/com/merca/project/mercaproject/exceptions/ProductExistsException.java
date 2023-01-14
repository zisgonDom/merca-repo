package com.merca.project.mercaproject.exceptions;

import jakarta.persistence.PersistenceException;

public class ProductExistsException extends PersistenceException{

	
	private static final long serialVersionUID = 2665287825112530476L;

	public ProductExistsException() {
		super("EAN alredy exists");
	}

}
