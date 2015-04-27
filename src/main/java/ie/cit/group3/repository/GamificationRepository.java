package ie.cit.group3.repository;

import ie.cit.group3.entity.Gamification;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

//@Repository
public interface GamificationRepository extends CrudRepository<Gamification, Integer> {
	//CrudRepository gives us access to inherited methods like save, findAll, delete etc & Convention over coding.

	
	
	
}
