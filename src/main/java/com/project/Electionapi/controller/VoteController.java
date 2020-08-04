package com.project.Electionapi.controller;

import com.project.Electionapi.dto.ResultElectionDTO;
import com.project.Electionapi.dto.VoteDTO;
import com.project.Electionapi.entity.Vote;
import com.project.Electionapi.service.VoteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.el.ELException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/voto")
public class VoteController {


    @Autowired
    private VoteService service;

    @GetMapping
    @ApiOperation(value = "Returns list of registered Votes")
    public List<Vote> list(){
        return service.getAll();
    }

    @GetMapping("/resultado/{id}")
    @ApiOperation(value = "Returns the election result by id")
    public List<ResultElectionDTO> result(@PathVariable("id") Integer idElection) {
        return service.resultElection(idElection);
    }

    @PostMapping
    @ApiOperation(value = "Register new vote")
    public Vote createVote(@RequestBody VoteDTO voteDTO) throws ELException {
        return service.add(voteDTO);
    }
}
