package ie.cit.group3;

/*import ie.cit.group.entity.Comment;
import ie.cit.group3.repository.CommentRepository;
import ie.cit.group3.repository.CrowdsourcingRepository;
import ie.cit.group3.repository.GameTypeRepository;
import ie.cit.group3.repository.GamificationLevelRepository;
import ie.cit.group3.repository.GamificationRepository;
import ie.cit.group3.repository.UserRepository;*/
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.OneToMany;

import ie.cit.group3.entity.Comment;
import ie.cit.group3.entity.Follow;
import ie.cit.group3.entity.GameType;
import ie.cit.group3.entity.Gamification;
import ie.cit.group3.entity.User;
import ie.cit.group3.repository.CommentRepository;
import ie.cit.group3.repository.CrowdsourcingRepository;
import ie.cit.group3.repository.FollowRepository;
import ie.cit.group3.repository.GameTypeRepository;
import ie.cit.group3.repository.GamificationLevelRepository;
import ie.cit.group3.repository.GamificationRepository;
import ie.cit.group3.repository.UserRepository;
import ie.cit.group3.service.ChObjectService;
import ie.cit.group3.service.ImageService;
import ie.cit.group3.service.ParticipantService;
import ie.cit.group3.service.ParticipationService;
import ie.cit.group3.service.RolesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;


@SpringBootApplication				//Annotation tells JDK that Spring Framework that this is a Spring project
@ActiveProfiles("default")			//Refer to application.yml for available profiles
public class CooperHewittG3WebApplication implements CommandLineRunner 
{

	@Autowired							//We can now reference the object jdbcTemplate anywhere in this class
	JdbcTemplate jdbcTemplate;

	@Autowired
	ChObjectService chObjectService;	//We can now reference the object jdbcTemplate anywhere in this class

	@Autowired
	ImageService imageService;			//We can now reference the object jdbcTemplate anywhere in this class

	@Autowired
	ParticipantService participantService;	//We can now reference the object jdbcTemplate anywhere in this class

	@Autowired
	ParticipationService participationService;	//We can now reference the object jdbcTemplate anywhere in this class

	@Autowired
	RolesService rolesService;					//We can now reference the object jdbcTemplate anywhere in this class

	@Autowired
	CommentRepository commentRepository;					
	@Autowired
	CrowdsourcingRepository crowdsourcingRepository;					
	@Autowired
	GameTypeRepository gameTypeRepository;					
	@Autowired
	GamificationLevelRepository gamificationLevelRepository;					
	@Autowired
	GamificationRepository gamificationRepository;					
	@Autowired
	UserRepository userRepository;					//We can now reference the object 
	@Autowired
	FollowRepository followRepository;					//We can now reference the object 
	
	

	
    public static void main(String[] args) {
        SpringApplication.run(CooperHewittG3WebApplication.class, args);
    }


	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
		Query01();
		
		
	}


	private void Query01() {
		// TODO Auto-generated method stub
		
		//save users
		userRepository.save(new User("test 1"));
		userRepository.save(new User("tom"));
		userRepository.save(new User("mary"));
		userRepository.save(new User("whatever"));
		
		//get users
		for (User user: userRepository.findAll())
				System.out.println(user);
		

		@SuppressWarnings("deprecation")
		Date date = new Date(2013, 11, 31);
//		repo.save(new Gamification(1,"200",false,false,"table","include",GameType.Collections<GameType>.emptyList(),10,Collections<Follow>.emptyList(), Collections<Comment>.emptyList(), 
//				date,false, date, "paul", "admin",date ));
		
		List<GameType> gametypes = new ArrayList<GameType>();
		gametypes.add(new GameType(10, "Tag word"));
		gametypes.add(new GameType(20, "Add Comment"));
		

		List<Follow> follows = new ArrayList<Follow>();
		follows.add(new Follow("paul", "mark"));
		follows.add(new Follow("mary", "ann"));	
		
//		Comment comment = new Comment("This is a great piece of art");
		
		gamificationRepository.save(new Gamification(1,"200",false,false,"table","include",gametypes,10,follows, 1, 
				date,false, date, "paul", "admin",date ));
		gamificationRepository.save(new Gamification(2,"300",false,false,"table1","include1",gametypes,20,follows,2 , 
				date,false, date, "paul11", "admin11",date ));
		
		for (Gamification user: gamificationRepository.findAll())
			System.out.println(user);
		
	}


}