package ie.cit.group3;

/*import ie.cit.group.entity.Comment;
import ie.cit.group3.repository.CommentRepository;
import ie.cit.group3.repository.CrowdsourcingRepository;
import ie.cit.group3.repository.GameTypeRepository;
import ie.cit.group3.repository.GamificationLevelRepository;
import ie.cit.group3.repository.GamificationRepository;
import ie.cit.group3.repository.UserRepository;*/
import java.sql.Date;

//import ie.cit.group3.entity.Comment;
import ie.cit.group3.entity.Crowdsourcing;
import ie.cit.group3.entity.GameType;
import ie.cit.group3.entity.Gamification;
/*import ie.cit.group3.entity.Comment;
import ie.cit.group3.entity.Follow;
import ie.cit.group3.entity.GameType;
import ie.cit.group3.entity.Gamification;*/
import ie.cit.group3.entity.User;
//import ie.cit.group3.repository.CommentRepository;
import ie.cit.group3.repository.CrowdsourcingRepository;
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

/*	@Autowired							//We can now reference the object jdbcTemplate anywhere in this class
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
	RolesService rolesService;		*/			//We can now reference the object jdbcTemplate anywhere in this class

//	@Autowired
//	CommentRepository commentRepository;					
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
//	@Autowired
//	FollowRepository followRepository;					//We can now reference the object 
	
	
	
    public static void main(String[] args) {
        SpringApplication.run(CooperHewittG3WebApplication.class, args);
    }


	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub

//		QuickTestUser();
//		QuickTestCrowdsourcing();
//		QuickTestGamification01();
//		QuickTestGamification02();
//		QuickTestGamification03(); //not working (i.e. Comments)
//		QuickTestGamification04(); //not working (i.e. Follow)
		
	}


	private void QuickTestGamification04() {
		// TODO Auto-generated method stub
		
		//testing Gamification 4 (Gamification02() + follow)
		@SuppressWarnings("deprecation")
		Date date = new Date(114, 0, 1); //Date.sql has a messed up way of doing date!! Enter a year - 1900 (i.e. 2014-1900= 114), month is 0-11 and day is day!

		User user3 = userRepository.findByUsername("alan");
		
//		Follow f = new Follow(1, "abby","tommy");
//		followRepository.save(f);
		
		
	//	GameType gt = new GameType(10, "Being Followed");
	//	gameTypeRepository.save(gt);
		
//		GameType gt = gameTypeRepository.findByGamename("Review");
//		System.out.println(gt);
//		 Gamification(User user, String chobject_id, GameType gametype,
//					int gamepoints, Date datestamp, String tagname, String storybookid,
//					boolean thumbup, boolean thumbdown, Follow follow, boolean flag,
//					String flagusername, Date flagdate, String adminflagreviewed,
//					Date adminflagdate)
					
//		Gamification gm4 = new Gamification(user3, "XX00", gt,
//				gt.getGamepoints(), date, null, null,
//				false, false, f, false, null, null, null, null);
//	
//		gamificationRepository.save(gm4);
		
		
	}



	private void QuickTestGamification01() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("deprecation")
		Date date = new Date(114, 0, 1); //Date.sql has a messed up way of doing date!! Enter a year - 1900 (i.e. 2014-1900= 114), month is 0-11 and day is day!


		//testing Gamification 1 (no comment, no gametype, no follow, no comment
		User user3 = userRepository.findByUsername("alan");

	Gamification gm = new Gamification(user3, "4000", 50, date, null, null, false, false, false, null, null, null, null);
//		Gamification(user3, String chobject_id, int gamepoints,
//				Date datestamp, String tagname, String storybookid,
//				boolean thumbup, boolean thumbdown, boolean flag,
//				String flagusername, Date flagdate, String adminflagreviewed,
//				Date adminflagdate)

		gamificationRepository.save(gm);
		
		for (Gamification user: gamificationRepository.findAll())
			System.out.println(user);


	}

	private void QuickTestGamification02() {
		// TODO Auto-generated method stub
		//testing Gamification 2 (Gamification01() + gametype)
		@SuppressWarnings("deprecation")
		Date date = new Date(114, 0, 1); //Date.sql has a messed up way of doing date!! Enter a year - 1900 (i.e. 2014-1900= 114), month is 0-11 and day is day!

		User user3 = userRepository.findByUsername("alan");
		
	//	GameType gt = new GameType(10, "Being Followed");
	//	gameTypeRepository.save(gt);
		
		GameType gt = gameTypeRepository.findByGamename("Review");
		System.out.println(gt);
//		Gamification(User user, String chobject_id, GameType gametype,
//				int gamepoints, Date datestamp, String tagname, String storybookid,
//				boolean thumbup, boolean thumbdown, boolean flag,
//				String flagusername, Date flagdate, String adminflagreviewed,
//				Date adminflagdate)
		Gamification gm2 = new Gamification(user3, "5000", gt,
				gt.getGamepoints(), date, null, null,
				false, false, false, null, null, null, null);
		gamificationRepository.save(gm2);
	}
	private void QuickTestGamification03() {
		// TODO Auto-generated method stub
		//testing Gamification 3 (Gamification02() + comment)
		
		@SuppressWarnings("deprecation")
		Date date = new Date(114, 0, 1); //Date.sql has a messed up way of doing date!! Enter a year - 1900 (i.e. 2014-1900= 114), month is 0-11 and day is day!

		User user3 = userRepository.findByUsername("alan");

//		Comment c = new Comment("what an amazing object!");
//		commentRepository.save(c);
	
	//	GameType gt = gameTypeRepository.findByGame_id(18);//findByGamename("Review");
		GameType gt = gameTypeRepository.findOne(1);
		GameType gt1 = gameTypeRepository.findOne(18);
		GameType gt2 = gameTypeRepository.findOne(45);
		
		System.out.println(gt);
		System.out.println(gt1);
		System.out.println(gt2);
//		 Gamification(User user, String chobject_id, GameType gametype,
//					int gamepoints, Date datestamp, String tagname, Comment comment,
//					String storybookid, boolean thumbup, boolean thumbdown,
//					boolean flag, String flagusername, Date flagdate,
//					String adminflagreviewed, Date adminflagdate)

//		Gamification gm3 = new  Gamification(user3, "9999", gt, gt.getGamepoints(), date, null, c,
//				null, false, false, false, null, null, null, null);
//		gamificationRepository.save(gm3);
		
	}
	private void QuickTestCrowdsourcing() {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("deprecation")
		Date date = new Date(114, 0, 1); //Date.sql has a messed up way of doing date!! Enter a year - 1900 (i.e. 2014-1900= 114), month is 0-11 and day is day!

		//Testing Crowdsourcing
		User user3 = userRepository.findByUsername("betty");
		Crowdsourcing cs = new Crowdsourcing( user3, "5010", "Interesting chair object",
				date, false, "betty", date,
				"admin", date);
//		Crowdsourcing cs1 = new Crowdsourcing(User user, String chobject_id, String description,
//				Date datestamp, boolean flag, String flagusername, Date flagdate,
//				String adminflagreviewed, Date adminflagdate);
		
		crowdsourcingRepository.save(cs );
	
	}


	private void QuickTestUser() {
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
		Date date = new Date(114, 0, 1); //Date.sql has a messed up way of doing date!! Enter a year - 1900 (i.e. 2014-1900= 114), month is 0-11 and day is day!

		//		Comment comment = new Comment("This is a great piece of art");
		//Testing User
		User user3 = new User("alan", "password", "A1",
				"Rossa Avenue", "Bishopstown", "Cork", "alan@mycit.ie",
				21, true,0 , date);
//		User(String username, String password, String profilename,
//				String address1, String address2, String address3, String email,
//				int age, boolean accountstatus, int pinid, Date datejoined);
		userRepository.save(new User("betty", "password", "B1",
				"Rossa Avenue", "Bishopstown", "Cork", "betty@mycit.ie",
				21, true,0 , date));
		userRepository.save(user3);
		
		
	}


}