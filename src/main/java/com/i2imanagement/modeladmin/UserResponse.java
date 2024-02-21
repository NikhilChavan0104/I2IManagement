package com.i2imanagement.modeladmin;

public class UserResponse {

	private Long id;
	private String userName;
	private String password;
	private String email;
	private String phone;
	private String vote;
	private Long userId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getVote() {
		return vote;
	}
	public void setVote(String vote) {
		this.vote = vote;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public UserResponse(Long id, String userName, String password, String email, String phone, String vote,
			Long userId) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.vote = vote;
		this.userId = userId;
	}
	public UserResponse() {
		super();
	}
	public UserResponse(Long id, String vote) {
		super();
		this.id = id;
		this.vote = vote;
	}
	
	
}
