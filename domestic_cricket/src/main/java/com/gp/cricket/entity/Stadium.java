package com.gp.cricket.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Stadium {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stadium_id")
	private Integer stadiumId;

	@NotBlank(message = "Stadium name is mandatory")
	@Column(name = "location")
	private String name;

	@NotBlank(message = "Address is mandatory")
	@Column(name = "address")
	private String address;

	@NotBlank(message = "Contact number is mandatory")
	@Size(min = 10, max = 10, message = "Contact number size should be 10")
	@Column(name = "contact_num")
	private String contactnum;
	
	@NotBlank(message = "Capacity is mandatory")
	@Column(name = "num_people")
	private Integer capacity;

	public Stadium() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stadium(Integer stadiumId, @NotBlank(message = "Stadium name is mandatory") String name,
			@NotBlank(message = "Address is mandatory") String address,
			@NotBlank(message = "Contact number is mandatory") @Size(min = 10, max = 10, message = "Contact number size should be 10") String contactnum,
			@NotBlank(message = "Capacity is mandatory") Integer capacity) {
		super();
		this.stadiumId = stadiumId;
		this.name = name;
		this.address = address;
		this.contactnum = contactnum;
		this.capacity = capacity;
	}

	public Integer getStadiumId() {
		return stadiumId;
	}

	public void setStadiumId(Integer stadiumId) {
		this.stadiumId = stadiumId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactnum() {
		return contactnum;
	}

	public void setContactnum(String contactnum) {
		this.contactnum = contactnum;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Stadium [stadiumId=" + stadiumId + ", name=" + name + ", address=" + address + ", contactnum="
				+ contactnum + ", capacity=" + capacity + "]";
	}
	
	

	}
