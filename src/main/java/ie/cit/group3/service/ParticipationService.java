package ie.cit.group3.service;


import ie.cit.group3.domain.Participation;
import java.util.List;

/**
 * @author John Murphy
 * Student Id: R00131347
 * Date: 	31st March 2015
 * 
 * This interface defines the contract/methods that a Participation can use at the Service Layer.
 * Activities are:
 * 	get			Retrieve record(s) that match a given id
 *  save		Save a object/record to the repository
 *  remove		Delete an object/record from the repository
 *  findAll		list all the objects/records in the repository
 * 
 */
public interface ParticipationService {
	
	public Participation get (String chObject_id, String participation_id, String role_id);
	
	public void save(Participation participation, String chObject_id);
	
	public void remove(Participation participation, String chObject_id);
	
	public List<Participation> findAll();
}
