package com.wellsfargo.fsd.sba3.exception;

public class CustomException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException(String errMsg){
		super(errMsg);
	}
}
