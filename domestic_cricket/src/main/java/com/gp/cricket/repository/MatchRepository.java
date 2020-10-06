package com.gp.cricket.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gp.cricket.entity.Club;
import com.gp.cricket.entity.Match;
import com.gp.cricket.entity.MatchType;

public interface MatchRepository extends JpaRepository<Match, Integer> {

	@Query("FROM Match m WHERE m.tournamentId.tournamentId = :tournamentId ORDER BY m.tournementRound ASC")
	public List<Match> findMatchesByTournamentId(@Param("tournamentId") Integer tournamentId);

	@Query("FROM Match m WHERE m.matchId = :matchId")
	public Match findMatchById(@Param("matchId") Integer matchId);
	
	
	@Query("FROM Match m WHERE m.finishDate <:currentDate AND m.tournamentId.tournamentId = :tournamentId ORDER BY m.tournementRound ASC")
	public List<Match> getPlayedMatches(@Param("currentDate") LocalDate currentDate,@Param("tournamentId") Integer tournamentId);
	
	@Query("FROM Match m WHERE m.finishDate >:currentDate AND m.tournamentId.tournamentId = :tournamentId ORDER BY m.tournementRound ASC")
	public List<Match> getToPlayMatches(@Param("currentDate") LocalDate currentDate,@Param("tournamentId") Integer tournamentId);
	

	@Query("FROM Match m WHERE (m.clubOneId = :clubId OR m.clubTwoId = :clubId) AND m.finishDate < current_date() ORDER BY m.finishDate DESC ")
	public List<Match> findPlayedMatchesByClubId(@Param("clubId")Integer clubId);

	
	@Query("FROM Match m WHERE m.finishDate >:currentDate AND m.tournamentId.tournamentId = :tournamentId AND m.refereeId.userId.userId =:refereeId AND m.state = 0 ORDER BY m.tournementRound ASC")
	public List<Match> getRefereeMatchesUpcomming(@Param("currentDate") LocalDate currentDate,@Param("tournamentId") Integer tournamentId,@Param("refereeId") Integer refereeId);
	
	@Query("FROM Match m WHERE m.finishDate <:currentDate AND m.tournamentId.tournamentId = :tournamentId AND m.refereeId.userId.userId =:refereeId AND m.state = 0 ORDER BY m.tournementRound ASC")
	public List<Match> getRefereeMatchesPlayed(@Param("currentDate") LocalDate currentDate,@Param("tournamentId") Integer tournamentId,@Param("refereeId") Integer refereeId);
	
		
	@Query("FROM Match m WHERE m.finishDate <:currentDate AND m.tournamentId.tournamentId = :tournamentId AND m.refereeId.userId.userId =:refereeId AND m.state =1 ORDER BY m.tournementRound ASC")
	public List<Match> getRefereeMatchesPlayedUpdated(@Param("currentDate") LocalDate currentDate,@Param("tournamentId") Integer tournamentId,@Param("refereeId") Integer refereeId);

	@Query("FROM Match m WHERE (m.clubOneId = :clubId OR m.clubTwoId = :clubId) AND m.startDate >= current_date() ORDER BY m.startDate ASC ")
	public List<Match> findUpcomingMatchesByClubId(@Param("clubId") Integer clubId);

	@Query("FROM Match m WHERE (m.startDate <= :currentDate AND m.finishDate >= :currentDate) AND m.refereeId.userId.userId =:refId ORDER BY m.startDate ASC ")
	public List<Match> getLiveMatchForReferee(@Param("refId")Integer refId,@Param("currentDate") LocalDate currentDate);

	@Query("SELECT COUNT(*) FROM Match m WHERE (m.clubOneId = :clubId OR m.clubTwoId = :clubId) AND  m.matchTypeId = :matchTypeId")
	public Integer getNumOfMatchPlayed(@Param("clubId") Integer clubId,@Param("matchTypeId") MatchType matchType);

	
	@Query("FROM Match m WHERE m.tournamentId.tournamentId = :tournamentId  ORDER BY m.startDate ASC")
	public List<Match> getMatchForpublic(Integer tournamentId);
	
	@Query("FROM Match m WHERE m.finishDate >:currentDate AND m.tournamentId.tournamentId = :tournamentId AND m.refereeId.userId.userId =:refereeId AND m.matchTypeId.matchTypeId = 1 AND m.state = 0 ORDER BY m.tournementRound ASC")
	public List<Match> getRefereeMatchesUpcommingOneDay(@Param("currentDate") LocalDate currentDate,@Param("tournamentId") Integer tournamentId,@Param("refereeId") Integer refereeId);
	
	@Query("FROM Match m WHERE m.finishDate >:currentDate AND m.tournamentId.tournamentId = :tournamentId AND m.refereeId.userId.userId =:refereeId AND m.matchTypeId.matchTypeId = 2 AND m.state = 0 ORDER BY m.tournementRound ASC")
	public List<Match> getRefereeMatchesUpcomming34Days(@Param("currentDate") LocalDate currentDate,@Param("tournamentId") Integer tournamentId,@Param("refereeId") Integer refereeId);
	
	@Query("FROM Match m WHERE m.finishDate >:currentDate AND m.tournamentId.tournamentId = :tournamentId AND m.refereeId.userId.userId =:refereeId AND m.matchTypeId.matchTypeId = 2 AND m.state = 0 ORDER BY m.tournementRound ASC")
	public List<Match> getRefereeMatchesUpcommingTTwenty(@Param("currentDate") LocalDate currentDate,@Param("tournamentId") Integer tournamentId,@Param("refereeId") Integer refereeId);
	
	@Query("FROM Match m WHERE m.finishDate <:currentDate AND m.tournamentId.tournamentId = :tournamentId AND m.refereeId.userId.userId =:refereeId AND m.matchTypeId.matchTypeId = 1 AND m.state = 0 ORDER BY m.tournementRound ASC")
	public List<Match> getRefereeMatchesPlayedOneDay(@Param("currentDate") LocalDate currentDate,@Param("tournamentId") Integer tournamentId,@Param("refereeId") Integer refereeId);
	
	@Query("FROM Match m WHERE m.finishDate <:currentDate AND m.tournamentId.tournamentId = :tournamentId AND m.refereeId.userId.userId =:refereeId AND m.matchTypeId.matchTypeId = 2  AND m.state = 0 ORDER BY m.tournementRound ASC")
	public List<Match> getRefereeMatchesPlayed34Days(@Param("currentDate") LocalDate currentDate,@Param("tournamentId") Integer tournamentId,@Param("refereeId") Integer refereeId);
	
	@Query("FROM Match m WHERE m.finishDate <:currentDate AND m.tournamentId.tournamentId = :tournamentId AND m.refereeId.userId.userId =:refereeId AND m.matchTypeId.matchTypeId = 3  AND m.state = 0 ORDER BY m.tournementRound ASC")
	public List<Match> getRefereeMatchesPlayedTTwenty(@Param("currentDate") LocalDate currentDate,@Param("tournamentId") Integer tournamentId,@Param("refereeId") Integer refereeId);
	
	
	
	@Query("FROM Match m WHERE m.finishDate <:currentDate AND m.tournamentId.tournamentId = :tournamentId AND m.refereeId.userId.userId =:refereeId AND m.matchTypeId.matchTypeId = 1  AND m.state =1 ORDER BY m.tournementRound ASC")
	public List<Match> getRefereeMatchesPlayedUpdatedOneDay(@Param("currentDate") LocalDate currentDate,@Param("tournamentId") Integer tournamentId,@Param("refereeId") Integer refereeId);
	
	@Query("FROM Match m WHERE m.finishDate <:currentDate AND m.tournamentId.tournamentId = :tournamentId AND m.refereeId.userId.userId =:refereeId AND m.matchTypeId.matchTypeId = 2  AND m.state =1 ORDER BY m.tournementRound ASC")
	public List<Match> getRefereeMatchesPlayedUpdated34Days(@Param("currentDate") LocalDate currentDate,@Param("tournamentId") Integer tournamentId,@Param("refereeId") Integer refereeId);
	
	@Query("FROM Match m WHERE m.finishDate <:currentDate AND m.tournamentId.tournamentId = :tournamentId AND m.refereeId.userId.userId =:refereeId AND m.matchTypeId.matchTypeId = 3  AND m.state =1 ORDER BY m.tournementRound ASC")
	public List<Match> getRefereeMatchesPlayedUpdatedTTwenty(@Param("currentDate") LocalDate currentDate,@Param("tournamentId") Integer tournamentId,@Param("refereeId") Integer refereeId);
	

}
