package com.project.Electionapi.repository;

import com.project.Electionapi.entity.Candidate;
import com.project.Electionapi.entity.CandidateElection;
import com.project.Electionapi.entity.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateElectionRepository extends JpaRepository<CandidateElection, Integer > {

    @Query("select cv.idCandidate from CandidateElection cv where cv.idElection=?1")
    List<Candidate> getListCandidate(Election election);


}