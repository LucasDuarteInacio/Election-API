package com.project.Electionapi.entity;


import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Data
@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    @Column(unique = true)
    private String cpf;


    @OneToMany
    private List<Election> elections = new ArrayList<>();


    public Candidate(Integer id, @NotNull String name, @NotNull String cpf, Election... listElections) {
        super();
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.elections = Stream.of(listElections).collect(Collectors.toList());
        this.elections.forEach(x -> x.getCandidates().add(this));
    }

}