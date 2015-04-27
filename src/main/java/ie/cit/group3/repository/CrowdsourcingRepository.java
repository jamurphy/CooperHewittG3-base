package ie.cit.group3.repository;

import ie.cit.group3.entity.Crowdsourcing;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface CrowdsourcingRepository extends CrudRepository<Crowdsourcing, Integer> {
	//CrudRepository gives us access to inherited methods like save, findAll, delete etc & Convention over coding.

	
}
