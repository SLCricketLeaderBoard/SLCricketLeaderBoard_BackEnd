package com.gp.cricket.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	Integer userId;

	@NotBlank(message = "User name is mandatory")
	String userName;

	@NotBlank(message = "Full Name is mandatory")
	String fullName;

	@NotBlank(message = "Name with initial is mandatory")
	String nameWithInitial;

	@NotBlank(message = "NIC is mandatory")
	@Size(min = 10, max = 12)
	String nic;

	@NotBlank(message = "Contact number is mandatory")
	@Size(min = 10, max = 10, message = "Contact number size should be 10")
	String contactNumber;

	@NotNull
	@Min(1)
	@Max(5)
	Byte type;

	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be valid")
	String email;

	@NotBlank(message = "Password is mandatory")
	String password;

	@NotBlank(message = "Address is mandatory")
	String address;

	@NotNull
	@DateTimeFormat(pattern = "MM-dd-YYYY")
	LocalDate regDate;

	@NotNull
	@Min(0)
	@Max(1)
	Byte status;

	public User() {
		super();
	}

	public User(@NotNull Integer userId, @NotBlank(message = "User name is mandatory") String userName,
			@NotBlank(message = "Full Name is mandatory") String fullName,
			@NotBlank(message = "Name with initial is mandatory") String nameWithInitial,
			@NotBlank(message = "NIC is mandatory") @Size(min = 10, max = 12) String nic,
			@NotBlank(message = "Contact number is mandatory") @Size(min = 10, max = 10, message = "Contact number size should be 10") String contactNumber,
			@NotNull @Min(1) @Max(5) Byte type,
			@NotBlank(message = "Email is mandatory") @Email(message = "Email should be valid") String email,
			@NotBlank(message = "Password is mandatory") String password,
			@NotBlank(message = "Address is mandatory") String address, @NotNull LocalDate regDate,
			@NotNull @Min(0) @Max(1) Byte status) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.fullName = fullName;
		this.nameWithInitial = nameWithInitial;
		this.nic = nic;
		this.contactNumber = contactNumber;
		this.type = type;
		this.email = email;
		this.password = password;
		this.address = address;
		this.regDate = regDate;
		this.status = status;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNameWithInitial() {
		return nameWithInitial;
	}

	public void setNameWithInitial(String nameWithInitial) {
		this.nameWithInitial = nameWithInitial;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", fullName=" + fullName + ", nameWithInitial="
				+ nameWithInitial + ", nic=" + nic + ", contactNumber=" + contactNumber + ", type=" + type + ", email="
				+ email + ", password=" + password + ", address=" + address + ", regDate=" + regDate + ", status="
				+ status + "]";
	}

}
