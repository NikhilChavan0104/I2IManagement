package com.i2imanagement.modeladmin;

public class AdminLoginResponse {

	private String message;
	private String statusCode;
	private String result;
	private String jwtToken;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	@Override
	public String toString() {
		return "AdminLoginResponse [message=" + message + ", statusCode=" + statusCode + ", result=" + result
				+ ", jwtToken=" + jwtToken + "]";
	}
	public AdminLoginResponse(String message, String statusCode, String result, String jwtToken) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.result = result;
		this.jwtToken = jwtToken;
	}
	public AdminLoginResponse() {
		super();
	}
	
	
	
}
