package ie.cit.group3.repository;

import ie.cit.group3.domain.Image;

import java.util.List;

/**
 * @author John Murphy
 * Student Id: R00131347
 * Date: 	31st March 2015
 * 
 * This interface defines the contract/methods that an Image can use on a Repository.
 * Activities are:
 * 	get			Retrieve record(s) that match a given id & resolution
 *  save		Save a object/record to the repository
 *  remove		Delete an object/record from the repository
 *  findAll		list all the objects/records in the repository
 * 
 */

public interface ImageRepository {
	
	public Image get (String id, String resolution);
	
	public void save(Image image);
	
	public void remove(Image image);
	
	public List<Image> findAll();

	List<Image> getO(String id);  //JM added 5/5/2015

}
