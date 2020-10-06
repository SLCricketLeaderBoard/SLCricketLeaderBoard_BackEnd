package com.gp.cricket.report.entity;

public class ClubPaymentReport {

	private Integer clubId;
	private String clubName;
	private String manager;
	private Double amount;

	public ClubPaymentReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClubPaymentReport(Integer clubId, String clubName, String manager, Double amount) {
		super();
		this.clubId = clubId;
		this.clubName = clubName;
		this.manager = manager;
		this.amount = amount;
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

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ClubPaymentReport [clubId=" + clubId + ", clubName=" + clubName + ", manager=" + manager + ", amount="
				+ amount + "]";
	}

}
