package com.qa.chirag.customexceptions;

public class FrameworkException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FrameworkException(String msg) {
		super(msg);
		printStackTrace();
	}
}