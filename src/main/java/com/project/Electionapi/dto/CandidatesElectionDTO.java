package com.project.Electionapi.dto;


import java.util.Date;
import java.util.List;



public class CandidatesElectionDTO {


    private String title;
    private Date start;
    private Date end;
    private String description;
    private List<Integer> idCandidates;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getidCandidates() {
        return idCandidates;
    }

    public void setidCandidates(List<Integer> idcandidates) {
        idCandidates = idcandidates;
    }
}
