package com.therealdanvega.excepion;

public class AdressNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdressNotFoundException(String msg) {
		super(msg);
	}
}
