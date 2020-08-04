package com.project.Electionapi.dto;

import com.project.Electionapi.entity.Candidate;

public class ResultElectionDTO {

    private Candidate candidate;

    private Integer totalVotes;



    public ResultElectionDTO(Candidate candidate, Integer totalVotes) {

        this.candidate = candidate;
        this.totalVotes = totalVotes;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Integer getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(Integer totalVotes) {
        this.totalVotes = totalVotes;
    }
}
