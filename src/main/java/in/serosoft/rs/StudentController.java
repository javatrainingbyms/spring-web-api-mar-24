package in.serosoft.rs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.serosoft.entity.Student;
import in.serosoft.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value="findById", produces = "application/json")
	public Student findById(@RequestParam("id") int id) {
		Student student=studentService.findById(id);
		return student;
	}
}
