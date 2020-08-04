package com.project.Electionapi.controller;

import com.project.Electionapi.entity.Candidate;
import com.project.Electionapi.repository.CandidateRepository;
import com.project.Electionapi.service.CandidateService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/candidato")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private CandidateService service;

    @GetMapping
    @ApiOperation(value = "returns list of registered candidates")
    public List<Candidate> list() {
        return candidateRepository.findAll();
    }

    @PostMapping
    @ApiOperation(value = "Register new Candidate")
    public Candidate addCandidate(@RequestBody Candidate candidate) {
        return service.add(candidate);
    }

    @PutMapping
    @ApiOperation(value = "Change a candidate")
    public Candidate alterCandidate(@RequestBody Candidate candidate) {
        return service.add(candidate);
    }

    @DeleteMapping(value="/{idCandidate}")
    @ApiOperation(value = "Delete a candidate by id")
    public void deleteCandidate(@PathVariable("idCandidate") Integer idCandidate) {
        service.deleteCandidate(idCandidate);

    }


}
