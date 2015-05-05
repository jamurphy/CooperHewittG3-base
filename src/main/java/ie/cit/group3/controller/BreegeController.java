package ie.cit.group3.controller;
//package ie.cit.group3.controller;

import java.util.List;

import ie.cit.group3.domain.ChObject;

import ie.cit.group3.service.ChObjectService;
import ie.cit.group3.service.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/display")
public class BreegeController {
	
	@Autowired
	ChObjectService chobject;
	
	@Autowired
	ImageService images;
	
	@RequestMapping(value="/listall/chobject", method = RequestMethod.GET) 
	public String listRole(ModelMap model) {			
			ChObject listchobject = new ChObject();
			listchobject.setId("1");
			listchobject.setTitle("a title");					
			//List<ChObject> listchobject = chobject.findAll();
			model.addAttribute("chobject", listchobject);
		    return "displayObject";			
		}    
	
}  