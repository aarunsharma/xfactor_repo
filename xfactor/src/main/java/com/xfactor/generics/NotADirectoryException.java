package com.xfactor.generics;

public class NotADirectoryException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		
		return "The path doesn't represent a directory";
	}
}
