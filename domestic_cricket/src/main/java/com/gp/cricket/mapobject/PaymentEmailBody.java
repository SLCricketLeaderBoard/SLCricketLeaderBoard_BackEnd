package com.gp.cricket.mapobject;

import java.time.LocalDate;

public class PaymentEmailBody {

	private String club;
	private Integer year;
	private LocalDate date;
	private Double amount;

	public PaymentEmailBody() {

	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PaymentEmailBody [club=" + club + ", year=" + year + ", date=" + date + ", amount=" + amount + "]";
	}

}
