package com.gp.cricket.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gp.cricket.entity.Manager;
import com.gp.cricket.entity.Stadium;
import com.gp.cricket.entity.User;
import com.gp.cricket.entity.Tournament;
import com.gp.cricket.service.TournamentService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class TournamentController {

    @Autowired
    TournamentService tournamentService;

    @PostMapping("tournamentRegister")
    public   registerTournament(@RequestBody Tournament tournament) {
        System.out.println(tournament);
        return tournamentService.registerTournament(tournament);
    }

    @GetMapping("/tournament")
    public List<Tournament> getAlltournament() {
        return this.tournamentService.getAllTournament();
    }

}
