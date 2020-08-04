package com.project.Electionapi.repository;

import com.project.Electionapi.dto.ResultElectionDTO;
import com.project.Electionapi.entity.Election;
import com.project.Electionapi.entity.User;
import com.project.Electionapi.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Query("Select v from Vote v where v.user=?1 and v.election=?2")
    Optional<Vote> findUserVote(User user, Election election);

    @Query("Select v.candidate, count(v) from Vote v where v.election=?1 group by v.candidate")
    List<ResultElectionDTO> getResult(Election election);

}
