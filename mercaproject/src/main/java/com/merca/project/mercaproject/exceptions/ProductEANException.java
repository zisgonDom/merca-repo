package com.merca.project.mercaproject.exceptions;

public class ProductEANException extends Exception{

	
	private static final long serialVersionUID = 7647275566109716190L;

	public ProductEANException() {
		super("EAN is empty");
	}
	
}
