package com.merca.project.mercaproject.exceptions;

import jakarta.persistence.PersistenceException;

public class EANNotExistsException extends PersistenceException {


	private static final long serialVersionUID = 811903171167977937L;

	public EANNotExistsException() {
		super("Not exists a product with this EAN");
	}

}
