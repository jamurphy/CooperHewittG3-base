package ie.cit.group3.repository;

import ie.cit.group3.entity.GamificationLevel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface GamificationLevelRepository extends CrudRepository<GamificationLevel, Integer>{
	//CrudRepository gives us access to inherited methods like save, findAll, delete etc & Convention over coding.

}
