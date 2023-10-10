package fr.cnalps.projetPiscine.controller;
/**
yolo
*/
import fr.cnalps.projetPiscine.model.Candidate;
import fr.cnalps.projetPiscine.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Candidates Controller
 */
@Controller
@RequestMapping(path="/candidate")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    /**
     * Fonction pour afficher tous les candidats
     * @return la liste des candidats
     */
    @GetMapping
    public @ResponseBody Iterable<Candidate> getAllCandidates(){
        return candidateService.findAll();
    }

    /**
     * Fonction d'affichage de candidats par id
     * @param id id du candidat recherché
     * @return le candidat recherché
     */
    @GetMapping("/{id}")
    public @ResponseBody Optional<Candidate> getCandidateById(@PathVariable(value ="id") int id){
        return candidateService.findById(id);
    }

    /**
     * Fonction de création d'un candidat
     * @param candidate les attributs candidat
     * @return sauvegarde des données
     */
    @PostMapping
    public @ResponseBody Candidate createCandidate(@RequestBody Candidate candidate){
        return candidateService.save(candidate);
    }

    /**
     * Fonction de suppression de candidats
     * @param id id du candidat à supprimer
     * @return la requête de suppression à la basse de données
     */
    @DeleteMapping("/{id}")
    public @ResponseBody String removeCandidate(@PathVariable(value = "id") int id) {
        candidateService.delete(id);
        return "Successfully deleted";
    }

    /**
     * Fonction de mise à jour des données du candidat
     * @param candidate les données du candidat
     * @return les nouvelles données du candidats à sauvegarder dans la BDD
     */
    @PutMapping(value = "/{id}")
    public @ResponseBody String modifyCandidate(@RequestBody Candidate candidate){
        candidateService.update(candidate);
        return "successfully modify";
    }
}
