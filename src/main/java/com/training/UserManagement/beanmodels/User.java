package com.training.UserManagement.beanmodels;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID", nullable = false)
	private int id;
	
	@NotEmpty
	@Column(name="FIRST_NAME", nullable=false)
	private String firstName;

	@NotEmpty	
	@Column(name="LAST_NAME", nullable=false)
	private String lastName;
	
	@NotEmpty	
	@Column(name="LOGINID", nullable = false)
	private String loginId;
	
	@NotEmpty	
	@Column(name="PASSWORD", nullable=false)
	private String password;
	
	@NotEmpty	
	@Column(name="ADDRESS", nullable=false)
	private String address;
	
	@NotEmpty	
	@Column(name="EMAIL", nullable=false)
	private String email;
	
	@NotEmpty	
	@Column(name="PHONE", nullable=false)
	private String phone;
	
	@NotNull	
	@Column(name="JOIN_DATE", nullable=false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date joinDate;
	
	@NotEmpty
	private String confirmPassword;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String userId) {
		this.loginId = userId;
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
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword){
		this.confirmPassword = confirmPassword;
	}
}
