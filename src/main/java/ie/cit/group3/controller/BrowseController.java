package ie.cit.group3.controller;

import java.util.List;

import ie.cit.group3.domain.ChObject;
import ie.cit.group3.domain.Image;
import ie.cit.group3.domain.Participant;
import ie.cit.group3.domain.Role;
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
	ImageService images;
	
	@RequestMapping(value="/listall/objects", method = RequestMethod.GET) 
	public String listAll(ModelMap model) {			
			
			List<ChObject> listobjects =chobject.findAll();
			model.addAttribute("objects", listobjects);
		    return "displayObjects";			
		}    
	
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