package com.merca.project.mercaproject.exceptions;

public class EmptyDescriptionException extends Exception{

	
	private static final long serialVersionUID = -2175552529228369332L;

	public EmptyDescriptionException() {
		super("Description is empty");
	}

	
}
