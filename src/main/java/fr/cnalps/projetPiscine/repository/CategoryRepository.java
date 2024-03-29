package fr.cnalps.projetPiscine.repository;

import org.springframework.data.repository.CrudRepository;

import fr.cnalps.projetPiscine.model.Category;
import org.springframework.stereotype.Repository;

/**
 * CRUD category interface
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{
}
