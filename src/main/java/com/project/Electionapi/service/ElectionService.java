package com.project.Electionapi.service;

import com.project.Electionapi.dto.CandidatesElectionDTO;
import com.project.Electionapi.dto.ElectionDTO;
import com.project.Electionapi.entity.Candidate;
import com.project.Electionapi.entity.CandidateElection;
import com.project.Electionapi.entity.Election;
import com.project.Electionapi.exception.ApiException;
import com.project.Electionapi.repository.CandidateElectionRepository;
import com.project.Electionapi.repository.ElectionRepository;
import com.project.Electionapi.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ElectionService {

    @Autowired
    private ElectionRepository electionRepository;

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private UserService userService;

    @Autowired
    private CandidateElectionRepository candidateElectionRepository;


    public Election findById(Integer id) {

        Optional<Election> election = electionRepository.findById(id);
        return election.orElseThrow(() -> new ApiException("Eleição com id: " + id + " não encontrada!",
                "Tipo: " + Election.class.getName(), HttpStatus.NOT_FOUND.value()));
    }

    public Election add(Election election) {
        return electionRepository.save(election);
    }

    public List<Election> getAll() {
        List<Election> item = electionRepository.findAll();
        for (Election vot : item) {
            Date date = vot.getEnd();
            vot.setStatus(DateUtil.isDateActive(date));

        }
        return item;
    }

    public void delete(Election election) {
        electionRepository.delete(election);
    }


    public Election addElection(Election election) {
        return electionRepository.save(election);

    }

    public void deleteElection(Integer idElection) {
        Election election = findById(idElection);
        delete(election);
    }

    public List<CandidateElection> createElection(CandidatesElectionDTO candidatesElectionDTO) {

        List<CandidateElection> listCandidateElection = new ArrayList<>();
        List<Integer> idCandidates = candidatesElectionDTO.getidCandidates();

        Election election = new Election(candidatesElectionDTO.getTitle(), candidatesElectionDTO.getStart(),
                candidatesElectionDTO.getEnd(), candidatesElectionDTO.getDescription());


        for (Integer idCandidate : idCandidates) {
            CandidateElection candidateElection = new CandidateElection();

            candidateElection.setIdElection(election);
            candidateElection.setIdCandidate(candidateService.findById(idCandidate));

            candidateElection = candidateElectionRepository.save(candidateElection);

            listCandidateElection.add(candidateElection);
        }
        return listCandidateElection;
    }

    public ElectionDTO getElectionById(Integer idElection) {
        Election election = findById(idElection);
        List<Candidate> listCandidates = candidateElectionRepository.getListCandidate(election);
        return new ElectionDTO(election.getId(), election.getTitle(), election.getDescription(), listCandidates);
    }


}

