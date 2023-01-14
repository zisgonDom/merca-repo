package com.merca.project.mercaproject.exceptions;

import java.io.Serial;

public class ShortEANException extends Exception{

	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 2430399183029735593L;

	public ShortEANException() {
		super("EAN doesn't contains 13 digits");
	}

	
}
