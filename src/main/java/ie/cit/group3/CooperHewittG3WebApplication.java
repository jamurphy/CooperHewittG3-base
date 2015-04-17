package ie.cit.group3;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import ie.cit.group3.domain.ChObject;
import ie.cit.group3.domain.Participant;
import ie.cit.group3.domain.Role;
import ie.cit.group3.service.ChObjectService;
import ie.cit.group3.service.ImageService;
import ie.cit.group3.service.ParticipantService;
import ie.cit.group3.service.ParticipationService;
import ie.cit.group3.service.RolesService;
import ie.cit.group3.utility.FileFinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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



	
	
    public static void main(String[] args) {
        SpringApplication.run(CooperHewittG3WebApplication.class, args);
    }





	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

/*
	@Override
	public void run(String... arg0) throws Exception 
	{
		*//**
		 * Entry point into application. Delegates to Spring boot command line runner.
		 *//*
		//Reading the directories to scan for JSON files from setting in 'Run Configurations...'
		//This is presently set for directory = "/Users/john/Documents/Git/Smithsonian/collection/objects/682/683/";
		//		String directory = arg0[0];
		//Hardcoding the directories to scan as reading the directory as an argument in 'Run Configurations...' was
		//causing an issue when I started using JUnit test.  A better way to do this would be to put the following
		//information into a properties file.
		ChObject object;								//Create reference to ChObject
		List<Path> paths = Collections.emptyList();		//Create List of file paths, and initialise to an empty list
		String directory ="/Users/john/Documents/Git/Smithsonian/collection/objects/682/683/";
		
		
		
		//File access is a checked exception. Using try/catch block to handle this.
		try 
		{
			paths = FileFinder.getFileList(directory, "*.json");			//scan directory tree structure and extract paths to Json files

			for (Path p : paths)				//cycle through list of file name/paths
			{
				//System.out.println(object.toString());

				//Access to a repository is a checked exception. Using try/catch to handle this.
				try	
				{
					//ObjectMapper() used to read in a file and parse it to create a new object for a supplied class
					//readValue(<file pointer>,<class>). Assigning data read from Json file (using Jackson) to ChObject
					//object 'object'
					object = new ObjectMapper().readValue(p.toFile(),ChObject.class);


					//Run query to see if an entry exists for object.getId() in Repository 
					//(In this program using a MySQL implementation and table is 'ChObject'. 
					//However, if another dB type is added, then a different table/storage name would be used)
					if (chObjectService.get(object.getId()) == null)
					{
						//add record to ChObject Table
						chObjectService.save(object);

						//Cycle through each Participation and check if Participants and Role have already been added to the Repository 
						for (int i = 0; i < object.getParticipants().size(); i++)
						{
							//PARTICIPANT: check if an entry for person_id is in repository already. Using variable pt for readability purposes only.
							Participant pt = participantService.get(object.getParticipants().get(i).getParticipant().getPerson_id());
							if (pt == null)
							{
								//Person not in repository so adding them
								participantService.save(object.getParticipants().get(i).getParticipant());
							}

							//ROLE: check if an entry for role_id is in repository already. Using variable re for readability purposes only.
							Role re = rolesService.get(object.getParticipants().get(i).getRole().getRole_id());
							if (re == null)
							{
								//Role not in repository so adding it
								rolesService.save(object.getParticipants().get(i).getRole());
							}

							//PARTICIPATION: check if an entry already exists in repository.
							if (participationService.get(object.getId(), 
									object.getParticipants().get(i).getParticipant().getPerson_id(), 
									object.getParticipants().get(i).getRole().getRole_id()) == null)
							{
								//Record for: ChObject_id,person_id,role_id Not in Participation repository so adding it
								participationService.save(object.getParticipants().get(i), object.getId());
							}
						}

						//IMAGES
						//Cycle through the images, and add non-duplicates (Criteria for duplicates: same: image_id and image resolution).
						for (int i = 0; i < object.getImages().size(); i++)
						{
							//Capture the 'keys' of the Map<key,value>. The key is the image resolution. Output this to String array 'keyArray'
							String[] keyArray = object.getImages().get(i).keySet().toArray(new String[0]);

							
							//Cycle through the image resolution
							for (int j = 0; j < keyArray.length; j++)
							{
								//check if an image with image_id & resolution exists in repository:
								if (imageService.get(object.getImages().get(i).get(keyArray[j]).getImage_id(), keyArray[j]) == null)
								{
									//set the ChObject_id and image resolution in the Image object before saving it.
									object.getImages().get(i).get(keyArray[j]).setChObjectId(object.getId());
									object.getImages().get(i).get(keyArray[j]).setResolution(keyArray[j]);

									//Record for image_id & resolution not in Image repository so adding it
									imageService.save(object.getImages().get(i).get(keyArray[j]));
								}
							}														
						}//End of Image processing
					}//End of ChObject processing.
				}
				catch (Exception e) 
				{
					System.out.println("Error occured while adding a record to the repository");
					e.printStackTrace();
				}
				
			} //end for loop (path)
			
			System.out.println("Finished Importing items to Repository");		
		
		}
		catch (JsonParseException e)
		{
			System.out.println("Error parsing the file.");
		}
		catch (JsonMappingException e)
		{
			System.out.println("Error mapping to Java object.");
		}
		catch (IOException e)
		{
			System.out.println("Unknown I/O error.");
		}
		
		
	}	*/
}