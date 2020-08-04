package com.project.Electionapi.service;

import com.project.Electionapi.entity.Candidate;
import com.project.Electionapi.exception.ApiException;
import com.project.Electionapi.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateService {


    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private UserService userService;


    public Candidate findById(Integer id) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        return candidate.orElseThrow(() -> new ApiException("Candidato com id: " + id + " não encontrado!",
                "Tipo: " + Candidate.class.getName(), HttpStatus.NOT_FOUND.value()));
    }

    public Candidate add(Candidate candidate) {
        return candidateRepository.save(candidate);
    }


    public void delete(Candidate candidate) {
        candidateRepository.delete(candidate);
    }


    public void deleteCandidate(Integer idCandidate) {
        Candidate candidate = findById(idCandidate);
        delete(candidate);
    }
}



