package fr.cnalps.projetPiscine.service;

import fr.cnalps.projetPiscine.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

@Service
public class ImagesService {
    private final CandidateRepository candidateRepository;

    @Autowired
    public ImagesService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }
    Path
}