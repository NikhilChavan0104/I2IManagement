package com.i2imanagement.modeladmin;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String adminName = "";
	
	private String email = "";
	private String phone = "";
	private String password = "";
	
	private String address = "";
	private String role = Constants.ADMIN.constant;
	private String userStatus = Constants.ACTIVE.constant;
	@Column(name = "reset_password_token")
	private String resetPasswordToken;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdOn = new Date();

	private String profileImage = "";

	public Admin() {
		super();
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminName=" + adminName + ", email=" + email + ", phone=" + phone + ", password="
				+ password + ", address=" + address + ", role=" + role + ", userStatus=" + userStatus
				+ ", resetPasswordToken=" + resetPasswordToken + ", createdOn=" + createdOn + ", profileImage="
				+ profileImage + "]";
	}

	public Admin(Long id, String adminName, String email, String phone, String password, String address, String role,
			String userStatus, String resetPasswordToken, Date createdOn, String profileImage) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.address = address;
		this.role = role;
		this.userStatus = userStatus;
		this.resetPasswordToken = resetPasswordToken;
		this.createdOn = createdOn;
		this.profileImage = profileImage;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	

}
