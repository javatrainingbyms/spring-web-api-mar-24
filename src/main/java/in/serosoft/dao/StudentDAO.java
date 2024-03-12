package in.serosoft.dao;

import java.util.List;
import java.util.Map;

import in.serosoft.entity.Student;

public interface StudentDAO {
	public Student save(Student student);
	public Student update(Student student);
	public Student delete(int id);
	public Student findById(int id);
	public List<Student> findAll();
	public Map findBranchInfo(int id);
	public List<Map> findAllBranchInfo();
	public List<Map> findStudentProjectInfo();
	//...
	//...
	
}
