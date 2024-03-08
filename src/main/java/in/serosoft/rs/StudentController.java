package in.serosoft.rs;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.serosoft.entity.Student;
import in.serosoft.service.StudentService;
import in.serosoft.ws.WSStudent;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private DozerBeanMapper mapper;
	
	@GetMapping(value="findBranchInfo", produces = "application/json")
	public WSStudent findByBranchInfo(@RequestParam("id") int id) {
		return studentService.findBranchInfo(id);
	}
	
	@GetMapping(value="findById", produces = "application/json")
	public Student findById(@RequestParam("id") int id) {
		Student student=studentService.findById(id);
		return student;
	}
	
	@PostMapping(value="create", produces="application/json", consumes="application/json")
	public Student saveStudent(@RequestBody Student student) {
		System.out.println("saving data...");
		Student st=studentService.save(student);
		return st;
	}
	
	@PutMapping(value="update", produces="application/json", consumes="application/json")
	public Student updateStudent(@RequestBody Student student) {
		System.out.println("update data...");
		Student st=studentService.update(student);
		return st;
	}
	@DeleteMapping(value="deleteById", produces="application/json")
	public Student updateStudent(@RequestParam("id") int id) {
		System.out.println("deleting data...");
		Student st=studentService.delete(id);
		return st;
	}
}
