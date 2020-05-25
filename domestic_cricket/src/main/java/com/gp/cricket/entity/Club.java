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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Club {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "club_id")
	private Integer clubId;

	@NotNull(message = "Club name is mandatory")
	private String clubName;

	@NotNull(message = "Address is mandatory")
	private String address;

	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be valid")
	private String email;

	@NotBlank(message = "Contact number is mandatory")
	@Size(min = 10, max = 10, message = "Contact number size should be 10")
	private String contactNumber;

	@NotNull
	@Min(0)
	private Integer winMatch;

	@NotNull
	@Min(0)
	private Integer failMatch;

	@NotNull
	@Min(0)
	private Integer growMatch;

	@NotNull
	@DateTimeFormat(pattern = "MM-dd-YYYY")
	private LocalDate regDate;

	@NotNull
	@OneToOne
	@JoinColumn(name = "manager_id", referencedColumnName = "manager_id")
	private Manager managerId;

	public Club() {

	}

	public Club(Integer clubId, @NotNull(message = "Club name is mandatory") String clubName,
			@NotNull(message = "Address is mandatory") String address,
			@NotBlank(message = "Email is mandatory") @Email(message = "Email should be valid") String email,
			@NotBlank(message = "Contact number is mandatory") @Size(min = 10, max = 10, message = "Contact number size should be 10") String contactNumber,
			@NotNull @Min(0) Integer winMatch, @NotNull @Min(0) Integer failMatch, @NotNull @Min(0) Integer growMatch,
			@NotNull LocalDate regDate, @NotNull Manager managerId) {
		super();
		this.clubId = clubId;
		this.clubName = clubName;
		this.address = address;
		this.email = email;
		this.contactNumber = contactNumber;
		this.winMatch = winMatch;
		this.failMatch = failMatch;
		this.growMatch = growMatch;
		this.regDate = regDate;
		this.managerId = managerId;
	}

	public Integer getClubId() {
		return clubId;
	}

	public void setClubId(Integer clubId) {
		this.clubId = clubId;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Integer getWinMatch() {
		return winMatch;
	}

	public void setWinMatch(Integer winMatch) {
		this.winMatch = winMatch;
	}

	public Integer getFailMatch() {
		return failMatch;
	}

	public void setFailMatch(Integer failMatch) {
		this.failMatch = failMatch;
	}

	public Integer getGrowMatch() {
		return growMatch;
	}

	public void setGrowMatch(Integer growMatch) {
		this.growMatch = growMatch;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public Manager getManagerId() {
		return managerId;
	}

	public void setManagerId(Manager managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Club [clubId=" + clubId + ", clubName=" + clubName + ", address=" + address + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", winMatch=" + winMatch + ", failMatch=" + failMatch
				+ ", growMatch=" + growMatch + ", regDate=" + regDate + ", managerId=" + managerId + "]";
	}

}
