package com.i2imanagement.modeladmin;

public enum Constants {
	ADMIN("Admin"),
	ACTIVE("Active"),
	INACTIVE("Inactive"),
	FIRST_NAME("first_name"),
	SESSION_EXPIRED_MESSAGE("Your session has expired. Please login to pick up where you left off."),
	INVALID_TOKEN_MESSAGE("Invalid Access Token !!!"),
	
	 TRUE("1"),
	 FALSE("0"),
	 INVALID_CREADINTIALS("Invalid Credintials"), 
	 AUTHORIZATION("Authorization"),
	 COMPANY_NAME("Pisyst India"),
	 CUSTOMER_SERVICE_MOB("+91 7620749234"),
	 CUSTOMER_SERVICE_EMAIL("nikhilchavan0104@gmail.com"),
	//Status codes...
	 CONTINUE("100"),
	 SWITCHING_PROTOCOLS("101"),
	 SUCCESS("200"),
	 INVALID_TOKEN("401"),
	 SESSION_EXPIRED("440"),
	 CREATED("201"),
	 ALREADY_EXIST("409"),
	 BAD_REQUEST("400"),
	 NOT_FOUND("404"),
	 UNAUTHORIZED("401"),
	
	 UPLOADPROFILEIMAGEDIRECTORY(System.getProperty("user.dir") + "/uploads/admin/images/profile/"),
	 UPLOADSLIDERIMAGEDIRECTORY(System.getProperty("user.dir") + "/uploads/admin/images/sliders/")
	 
	
	
	;
	final public String constant;

	private Constants(String constant) {
		this.constant = constant;
	}

}
