package com.i2imanagement.modeladmin;

import org.springframework.web.multipart.MultipartFile;

public class AdminResponse {

	private Long id;
	private String adminName = "";
	private String email = "";
	private String phone = "";
	
	private String address = "";
	private String role = Constants.ADMIN.constant;
	private String userStatus = Constants.ACTIVE.constant;
	private String profileImage ;
	public AdminResponse(Long id, String adminName, String email, String phone, String address, String role,
			String userStatus, String profileImage) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
		this.userStatus = userStatus;
		this.profileImage = profileImage;
	}
	@Override
	public String toString() {
		return "AdminResponse [id=" + id + ", adminName=" + adminName + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", role=" + role + ", userStatus=" + userStatus + ", profileImage="
				+ profileImage + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public AdminResponse() {
		super();
	}
	
	

	
	
}
