package ie.cit.group3.repository;


import ie.cit.group3.domain.Participant;

import java.util.List;

/**
 * @author John Murphy
 * Student Id: R00131347
 * Date: 	31st March 2015
 * 
 * This interface defines the contract/methods that a Participant can use on a Repository.
 * Activities are:
 * 	get			Retrieve record(s) that match a given id
 *  save		Save a object/record to the repository
 *  remove		Delete an object/record from the repository
 *  findAll		list all the objects/records in the repository
 * 
 */

public interface ParticipantRepository {
	
	public Participant get (String id);
	
	public void save(Participant participant);
	
	public void remove(Participant participant);
	
	public List<Participant> findAll();

}
