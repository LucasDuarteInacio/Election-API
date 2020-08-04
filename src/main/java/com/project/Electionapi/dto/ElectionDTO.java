package com.project.Electionapi.dto;

import java.util.List;

import com.project.Electionapi.entity.Candidate;

public class ElectionDTO {


    private Integer idElection;
    private String title;
    private String description;
    private List<Candidate> listCandidates;

    public ElectionDTO(){}

    public ElectionDTO(Integer idElection, String title, String description, List<Candidate> listCandidates) {
        this.idElection = idElection;
        this.title = title;
        this.description = description;
        this.listCandidates = listCandidates;
    }

    public Integer getIdElection() {
        return idElection;
    }

    public void setIdElection(Integer idElection) {
        this.idElection = idElection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Candidate> getListCandidates() {
        return listCandidates;
    }

    public void setListCandidates(List<Candidate> listCandidates) {
        this.listCandidates = listCandidates;
    }
}


