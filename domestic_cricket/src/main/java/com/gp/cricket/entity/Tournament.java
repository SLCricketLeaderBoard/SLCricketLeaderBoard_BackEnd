package com.gp.cricket.entity;

import java.time.LocalDate;
import java.util.Date;

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
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_id")
    private Integer tournamentId;

    @NotBlank(message = "Tournament name is mandatory")
    @Column(name = "tournament_name")
    private String tournamentName;

    @NotBlank(message = "Start Date is mandatory")
    @Column(name = "start_date")
    private Date startDate;

    @NotBlank(message = "S Date is mandatory")
    @Column(name = "end_date")
    private Date endDate;

    public Tournament() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Tournament(Integer tournamentId,
            @NotBlank(message = "Tournament id name is mandatory") String tournamentName,
            @NotBlank(message = "Address is mandatory") String address,
            @NotBlank(message = "Contact number is mandatory") @Size(min = 10, max = 10, message = "Contact number size should be 10") String contactnum,
            @NotBlank(message = "Capacity is mandatory") Integer capacity) {
        super();
        this.tournamentName = tournamentName;
        this.tournamentId = tournamentId;
        this.startDate = startDate;
        this.startDate = startDate;

    }

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Integer TournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setName(String name) {
        this.tournamentName = tournamentName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String address) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endtDate;
    }

    public void setEndDate(String address) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Tournament [tournamentId=" + tournamentId + ", tournamentName=" + tournamentName + ", startDate="
                + startDate + ", endDate=" + endDate + "]";
    }

}
