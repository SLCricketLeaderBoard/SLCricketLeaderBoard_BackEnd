package com.gp.cricket.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "tournement")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournement_id")
    private Integer tournamentId;

    @NotBlank(message = "Tournament name is mandatory")
    @Column(name = "tournement_name")
    private String tournamentName;

    @NotBlank(message = "Start Date is mandatory")
    @Column(name = "start_date")
    private Date startDate;

    @NotBlank(message = "Enad Date is mandatory")
    @Column(name = "end_date")
    private Date endDate;

    public Tournament() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Tournament(Integer tournamentId,
            @NotBlank(message = "Tournament id name is mandatory") String tournamentName,
            @NotBlank(message = "Start Date is mandatory") Date startDate,
            @NotBlank(message = "End Date is mandotaory") Date endDate
            ) {
        super();
        this.tournamentName = tournamentName;
        this.tournamentId = tournamentId;
        this.startDate = startDate;
        this.startDate = startDate;

    }



    public Integer getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(Integer tournamentId) {
		this.tournamentId = tournamentId;
	}

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
    public String toString() {
        return "Tournament [tournamentId=" + tournamentId + ", tournamentName=" + tournamentName + ", startDate="
                + startDate + ", endDate=" + endDate + "]";
    }

}
