package in.serosoft.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.serosoft.dao.StudentDAO;
import in.serosoft.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Student save(Student student) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(student);
		tr.commit();
		session.close();
		return student;
	}

	@Override
	public Student update(Student student) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(student);
		tr.commit();
		session.close();
		return student;
	}

	@Override
	public Student delete(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Student student=findById(id);
		session.delete(student);
		tr.commit();
		session.close();
		return student;
	}

	@Override
	public Student findById(int id) {
		Session session=sessionFactory.openSession();
		Student student=session.get(Student.class, id);
		return student;
	}

	@Override
	public List<Student> findAll() {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Student.class);
		List<Student> studentList=criteria.list();
		session.close();
		return studentList;
	}

}
