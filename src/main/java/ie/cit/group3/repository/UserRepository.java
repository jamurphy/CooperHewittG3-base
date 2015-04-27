package ie.cit.group3.repository;

import java.util.List;

import ie.cit.group3.entity.User;


//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
//@Qualifier(value = "userRepository")  //give the name we will assign to all autowired variables
public interface UserRepository extends CrudRepository<User, Integer> {
	//CrudRepository gives us access to inherited methods like save, findAll, delete etc & Convention over coding.

	public User findByUsername(String username);

	
}