package com.senpiper.liv2train.BEAN;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EnrollmentBean {
	
	private int id;
	@NotEmpty(message="Required Field")
	@Size(max = 40,message="Less than 40 character")
	private String centerName;
	@NotEmpty(message="Required Field")
	@Pattern(regexp = "^[A-Za-z0-9]+$",message="Invalid Center Code")
	@Size(min=12,max=12)
	private String centerCode;
	@NotNull(message="Required Field")
	private Address address;
	private int studentCapacity;
	private List<String> courseOffered;
	private Date createdOn;
	@Email(message = "Invalid Email")
	private String email;
	@NotEmpty(message="Required Field")
	@Size(min=10,max=10)
	private String mobileNumber;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterCode() {
		return centerCode;
	}
	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}
	
	public int getStudentCapacity() {
		return studentCapacity;
	}
	public void setStudentCapacity(int studentCapacity) {
		this.studentCapacity = studentCapacity;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getCourseOffered() {
		return courseOffered;
	}
	public void setCourseOffered(List<String> courseOffered) {
		this.courseOffered = courseOffered;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		Date date = new Date(); 
		createdOn = date;
		this.createdOn = createdOn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	
}
