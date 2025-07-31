package WeatherWiseAI.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import WeatherWiseAI.Entity.Weather_Data;
import WeatherWiseAI.Service.AI_Service_Methods;
@RestController
@CrossOrigin(origins = "http://localhost:3000") 
public class WeatherAIController {
	private AI_Service_Methods m ;
	public WeatherAIController (AI_Service_Methods m) {
		this.m = m ;
	}
	
	@PostMapping("/genai")
	public String ai(@RequestBody Weather_Data w) {
		return m.genAI(w) ;
		
	}
	@GetMapping("/home")
	public String home () {
		return "Hello" ;
	}
	
	@GetMapping("/greetme") 
	public String greet () {
		return m.greetMe() ;
	}

}
