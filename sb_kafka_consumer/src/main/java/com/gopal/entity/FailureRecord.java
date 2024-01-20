package com.gopal.entity;

public class FailureRecord {
	
	private int id;
	
	private String errorMessage;

	public FailureRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FailureRecord(int id, String errorMessage) {
		super();
		this.id = id;
		this.errorMessage = errorMessage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "FailureRecord [id=" + id + ", errorMessage=" + errorMessage + "]";
	}
	
	

}
