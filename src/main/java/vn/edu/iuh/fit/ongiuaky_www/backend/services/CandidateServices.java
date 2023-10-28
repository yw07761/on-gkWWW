package vn.edu.iuh.fit.ongiuaky_www.backend.services;

import vn.edu.iuh.fit.ongiuaky_www.backend.enums.Roles;
import vn.edu.iuh.fit.ongiuaky_www.backend.models.Candidate;
import vn.edu.iuh.fit.ongiuaky_www.backend.repositories.CandidateRepository;

import java.util.List;

public class CandidateServices {
    private final CandidateRepository candidateRepository;

    public CandidateServices() {
        candidateRepository = new CandidateRepository();
    }

    public List<Candidate> findAllCandidate() {
        return candidateRepository.findAllCandidate();
    }

    public List<Candidate> getCanditeFromRole(int role) {
        return candidateRepository.getCanditeFromRole(role);
    }

}
