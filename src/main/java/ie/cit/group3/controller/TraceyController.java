package ie.cit.group3.controller;

//Tracey controller class 

import ie.cit.group3.entity.User;
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
public class TraceyController {
	
	@Autowired
	ChObjectService chobject;
	@Autowired
	RolesService roles;
	@Autowired
	ParticipantService participants;
		@Autowired
	ImageService images;
	
		
		@RequestMapping(value="/listall/users", method = RequestMethod.GET) 
	
	public String findByUsername(ModelMap model) {	

		 
		 
//		 User user1 = new User();
//		 user1.setId(1234);
//		 user1.setUsername("Tracey");
//		 
//		 model.addAttribute("user", user1);
		 
	    return "displayUserProfile" ;	
	}    
}             