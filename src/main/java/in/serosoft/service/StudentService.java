package in.serosoft.service;

import java.util.List;
import java.util.Map;

import in.serosoft.entity.Student;
import in.serosoft.ws.WSStudent;
import in.serosoft.ws.WSStudentProject;

public interface StudentService {
	public Student save(Student student);
	public Student update(Student student);
	public Student delete(int id);
	public Student findById(int id);
	public List<Student> findAll();
	public WSStudent findBranchInfo(int id);
	public List<Map> findAllBranchInfo(); 
	public List<WSStudentProject> findStudentProjectInfo();
}
