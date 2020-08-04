package com.project.Electionapi.service;

import com.project.Electionapi.dto.ResultElectionDTO;
import com.project.Electionapi.dto.VoteDTO;
import com.project.Electionapi.entity.Candidate;
import com.project.Electionapi.entity.Election;
import com.project.Electionapi.entity.User;
import com.project.Electionapi.entity.Vote;
import com.project.Electionapi.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.el.ELException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private ElectionService votacaoSevice;

    @Autowired
    private UserService userService;

    public Vote add(VoteDTO voteDTO) throws ELException {
        User user = this.userService.findById(voteDTO.getIdUser());
        Candidate candidate = this.candidateService.findById(voteDTO.getIdCandidate());
        Election election = this.votacaoSevice.findById(voteDTO.getIdElection());
        Date date = new Date();

        Vote vote = new Vote(null,election, candidate, user, date);

        Optional<Vote> votoUsuario = voteRepository.findUserVote(user, election);

        if(votoUsuario.isPresent()) {
            throw new ELException("voto ja cadastrado");
        }

        vote.setDate(date);
        return  registerVote(vote);

    }
    public List<ResultElectionDTO> resultElection(Integer votacaoId) {
        Election votacao = votacaoSevice.findById(votacaoId);
        return voteRepository.getResult(votacao);

    }

    public List<Vote> getAll(){
        return voteRepository.findAll();
    }



    public Vote registerVote(Vote vote) {
        return voteRepository.save(vote);
    }
}
