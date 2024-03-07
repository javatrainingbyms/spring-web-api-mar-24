package in.serosoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.serosoft.dao.StudentDAO;
import in.serosoft.entity.Student;
import in.serosoft.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public Student save(Student student) {
		return studentDAO.save(student);
	}

	@Override
	public Student update(Student student) {
		return studentDAO.update(student);
	}

	@Override
	public Student delete(int id) {
		return studentDAO.delete(id);
	}

	@Override
	public Student findById(int id) {
		Student student=studentDAO.findById(id);
		return student;
	}

	@Override
	public List<Student> findAll() {
		return studentDAO.findAll();
	}

}
