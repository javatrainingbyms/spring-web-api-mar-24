package in.serosoft.service.impl;

import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.serosoft.dao.StudentDAO;
import in.serosoft.entity.Student;
import in.serosoft.service.StudentService;
import in.serosoft.ws.WSStudent;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private DozerBeanMapper mapper;
	
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

	@Override
	public WSStudent findBranchInfo(int id) {
		Map map=studentDAO.findBranchInfo(id);
		WSStudent wsStudent=mapper.map(map, WSStudent.class);
		if(wsStudent.getMarks()>=33) {
			wsStudent.setResult("passed");
		}else {
			wsStudent.setResult("failed");
		}
		return wsStudent;
	}

}
