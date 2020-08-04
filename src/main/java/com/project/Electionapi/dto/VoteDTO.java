package com.project.Electionapi.dto;

public class VoteDTO {

    private Integer idElection;
    private Integer idUser;
    private Integer idCandidate;

    public VoteDTO(Integer idElection, Integer idUser, Integer idCandidate) {
        this.idElection = idElection;
        this.idUser = idUser;
        this.idCandidate = idCandidate;
    }

    public Integer getIdElection() {
        return idElection;
    }

    public void setIdElection(Integer idElection) {
        this.idElection = idElection;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(Integer idCandidate) {
        this.idCandidate = idCandidate;
    }
}
