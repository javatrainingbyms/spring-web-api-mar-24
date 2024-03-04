package in.serosoft;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {

	@GetMapping("/test")
	public String testAPI() {
		return "Success..!";
	}
	
	@GetMapping("/demo")
	public String demoAPI() {
		return "WELCOME USER...!";
	}
}
