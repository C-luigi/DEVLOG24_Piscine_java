package fr.cnalps.projetPiscine.service;

import fr.cnalps.projetPiscine.model.Candidate;
import fr.cnalps.projetPiscine.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service candidate
 */
@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;
    private ImagesService imagesService;

    /**
     * List all candidates service function
     * @return Candidates list
     */
    public Iterable<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    /**
     * List one candidate by Id function
     * @param id candidate
     * @return candidate
     */
    public Optional<Candidate> findById(int id){
        return candidateRepository.findById(id);
    }

    public Candidate save(Candidate candidate){
        return candidateRepository.save(candidate);
    }

    /**
     * Delete candidate service function
     * @param candidate object
     */
    public void delete(int candidate){
         candidateRepository.deleteById(candidate);
    }

    /**
     * update candidate information service function
     * @param candidate object
     */
    public void update(Candidate candidate){
        candidateRepository.save(candidate);
    }

}
