package com.project.Electionapi.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Election {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date start;

    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date end;

    private String description;

    @JsonManagedReference
    @OneToMany(mappedBy = "elections")
    private List<Candidate> candidates = new ArrayList<>();

    private Boolean status;



    public Election(String title, Date start, Date end, String description) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.description = description;
    }



}