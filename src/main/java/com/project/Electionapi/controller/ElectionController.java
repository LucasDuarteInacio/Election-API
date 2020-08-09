package com.project.Electionapi.controller;

import com.project.Electionapi.dto.CandidatesElectionDTO;
import com.project.Electionapi.dto.ElectionDTO;
import com.project.Electionapi.entity.CandidateElection;
import com.project.Electionapi.entity.Election;
import com.project.Electionapi.repository.ElectionRepository;
import com.project.Electionapi.service.ElectionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/election")
public class ElectionController {

    @Autowired
    private ElectionRepository electionRepository;

    @Autowired
    private ElectionService service;


    @GetMapping
    @ApiOperation(value = "Returns list of all Elections")
    public List<Election> list(){
        return service.getAll();
    }

    @GetMapping("/detail/{id}")
    @ApiOperation(value = "Returns detail a election by id ")
    public ElectionDTO detailElection(@PathVariable("id") Integer idElection){
        return service.getElectionById(idElection);
 
    }
    @PostMapping
    @ApiOperation(value = "Create a new election")
    public List<CandidateElection> addElection(@RequestBody CandidatesElectionDTO candidatesElectionDTO) {
        return service.createElection(candidatesElectionDTO);
    }

    @DeleteMapping(value = "/{idElection}")
    @ApiOperation(value = "Delete a election by id")
    public void deleteElection(@PathVariable("idElection") Integer idElection) {
        service.deleteElection(idElection);
    }


}
