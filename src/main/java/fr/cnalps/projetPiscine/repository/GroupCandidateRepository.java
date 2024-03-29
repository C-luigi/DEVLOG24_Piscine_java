package fr.cnalps.projetPiscine.repository;

import org.springframework.data.repository.CrudRepository;

import fr.cnalps.projetPiscine.model.GroupCandidate;
import org.springframework.stereotype.Repository;

/**
 * CRUD GroupCandidates interface
 */
@Repository
public interface GroupCandidateRepository extends CrudRepository<GroupCandidate, Integer>{
}
