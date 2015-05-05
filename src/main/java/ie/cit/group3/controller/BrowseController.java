package ie.cit.group3.controller;

import java.util.List;

import ie.cit.group3.JdbcTemplateTestApplication;
import ie.cit.group3.domain.ChObject;
import ie.cit.group3.domain.Image;
import ie.cit.group3.domain.Participant;
import ie.cit.group3.domain.Role;
import ie.cit.group3.repository.ImageRepository;
import ie.cit.group3.service.ChObjectService;
import ie.cit.group3.service.ImageService;
import ie.cit.group3.service.ParticipantService;
import ie.cit.group3.service.RolesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/browse")
public class BrowseController {
	
	@Autowired
	ChObjectService chobject;
	
	@Autowired
	RolesService roles;
	
	@Autowired
	ParticipantService participants;
	
	@Autowired
	ImageRepository images;  //changed to Repository (from Service 5/5/2015...change back once debugged)
	
	@RequestMapping(value="/listall/objects", method = RequestMethod.GET) 
	public String listAll(ModelMap model) {			
			
			List<ChObject> listobjects =chobject.findAll();
			model.addAttribute("objects", listobjects);
		    return "displayObjects";			
		}  
	
	@RequestMapping(value="/object/id", method = RequestMethod.GET) 
	public String listObject(ModelMap model) {			
			
		//next step to pass chObjectID in as parameter
		String id = "18094365";
		
			ChObject object = chobject.get(id);
			Image objectimage= new Image();
			
			List<Image> objectImages = images.getO(id);
			int maxwidth = 0;

			if (objectImages != null)
			{
				for (int i = 0; i < objectImages.size() ; i++)
				{
					if (objectImages.get(i).getUrl() != null)
					{
						if (objectImages.get(i).getWidth() > maxwidth)
						{
							maxwidth = objectImages.get(i).getWidth();
							objectimage = objectImages.get(i);
						}		
					}
				}
			}
			else
			{
				System.out.println("No objects!");
			}
			
			System.out.println(objectimage);
//			System.out.println(allimages.get(10));
//			System.out.println(allimages.get(12));
//			System.out.println(objectimage);
//			if (objectimage==null)
//				objectimage = allimages.get(0);
			model.addAttribute("object", object);
			model.addAttribute("image", objectimage);
		    return "displayItem";			
		}  
	
//	
//	@RequestMapping(value="/listall/import", method = RequestMethod.GET) 
//	public String importObjects(ModelMap model) {			
//			
//		JdbcTemplateTestApplication importObjects = new JdbcTemplateTestApplication();
//			
//		List<ChObject> listobjects =chobject.findAll();
//			model.addAttribute("objects", listobjects);
//		    return "displayObjects";			
//		}   
	
	@RequestMapping(value="/listall/roles", method = RequestMethod.GET) 
	public String listRole(ModelMap model) {			
			
			List<Role> listroles = roles.findAll();
			model.addAttribute("roles", listroles);
		    return "displayRoles";			
		}    
	
	@RequestMapping(value="/listall/participants", method = RequestMethod.GET) 
	public String listParticipant(ModelMap model) {			
			
			List<Participant> listparticipants = participants.findAll();
			model.addAttribute("participants", listparticipants);
		    return "displayParticipants";			
		}    
	
	@RequestMapping(value="/listall/images", method = RequestMethod.GET) 
	public String listImage(ModelMap model) {			
			
			List<Image> listimages = images.findAll();
			model.addAttribute("images", listimages);
		    return "displayImages";			
		}  
}             