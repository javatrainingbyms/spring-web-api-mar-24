package in.serosoft.service;

import java.util.List;

import in.serosoft.entity.Student;

public interface StudentService {
	public Student save(Student student);
	public Student update(Student student);
	public Student delete(int id);
	public Student findById(int id);
	public List<Student> findAll();
}
