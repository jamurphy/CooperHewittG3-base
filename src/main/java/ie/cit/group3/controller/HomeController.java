/*package ie.cit.group3.controller;

import java.util.List;

import ie.cit.group3.domain.ChObject;
import ie.cit.group3.service.ChObjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@Controller //Indicates class is a controller
@RestController //RestController required if using Method = RequestMethod.GET
//@RequestMapping("/")
//@RequestMapping(value={"/","/home"})
@EnableAutoConfiguration
public class HomeController {

	@Autowired							//We can now reference the object jdbcTemplate anywhere in this class
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ChObjectService chObjectService;	//We can now reference the object jdbcTemplate anywhere in this class

	//@RequestMapping(value={"/","/home"}, method = RequestMethod.GET) 

	//@RequestMapping(value={"/","/home"}) 
	@RequestMapping(value={"/","/home"}) //firstly, identifies showHomPage() as a request handling method. It also specifies to use the method for '/' or '/home'
	public String showHomePage(ModelMap model) { //ModelMap represents the model which the data thats passed between controller and view
		
		System.out.println("Will try and retrieve some chobjects");
		
//		model.addAttribute("message", "This is Cooper Hewitt home page."); //Returning data (to the view for display).
//		model.addAttribute("yadda","yadda Testing the passing of data");
		
//		System.out.println("Will try and retrieve object");
		List<ChObject> ch = chObjectService.findAll();
		System.out.println(ch.get(0).toString());
//		System.out.println("received object");
		model.addAttribute("object", ch);
//		model.addAttribute("oDesc", ch.getDescription());
	
		
		return "home1"; //returns the View name
		//return "classpath:resources/templates/home";
	} 
}
*/
