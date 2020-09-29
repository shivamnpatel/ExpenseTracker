package com.expensetracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class RegisterUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@NotBlank(message = "* Username cannot be blank")
	@Size(min = 5, message = "* Minimum 5 char")

	private String userName;
	
	@NotBlank(message = "* Email cannot be blank")
	@Email
	private String email;

	@NotBlank
	@Size(max = 10, message = "* Mobile no should be of 10 digit")
	private String mobileNo;

	@NotBlank(message = "* Password cannot be blank")
	private String password;

	public RegisterUser() {

	}

	public RegisterUser(int userId, String userName, String email, String mobileNo, String password) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RegisterUser [userId=" + userId + ", userName=" + userName + ", email=" + email + ", mobileNo="
				+ mobileNo + ", password=" + password + "]";
	}

}
