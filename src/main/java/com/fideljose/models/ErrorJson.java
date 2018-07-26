package com.fideljose.models;

import java.util.Map;

public class ErrorJson {

	private Integer status;
	private String error;
	private String message;
	private String timeStamp;
	private String trace;
	
	public ErrorJson(Integer status, Map<String, Object> errorAttribute) {
		this.status = status;
		this.error = (String) errorAttribute.get("error");
		this.message = (String) errorAttribute.get("message");
		this.timeStamp = (String) errorAttribute.get("timeStamp");
		this.trace = (String) errorAttribute.get("trace");
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTrace() {
		return trace;
	}

	public void setTrace(String trace) {
		this.trace = trace;
	}
	
	
	
}
