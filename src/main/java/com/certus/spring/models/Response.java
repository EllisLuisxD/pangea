package com.certus.spring.models;

import java.util.List;

public class Response <T>{
	
	public Boolean Success;
	public String Message;
	public List<String> Errors;
	public T data;
	public Boolean getSuccess() {
		return Success;
	}
	public void setSuccess(Boolean success) {
		Success = success;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public List<String> getErrors() {
		return Errors;
	}
	public void setErrors(List<String> errors) {
		Errors = errors;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	
}
