package in.serosoft.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.serosoft.dao.StudentDAO;
import in.serosoft.entity.Student;
import in.serosoft.utility.DAOUtil;

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

	@Override
	public Map findBranchInfo(int id) {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("id", id));
		Map<String,String> map=DAOUtil.getProjectionInstance();
		map.put("id", "id");
		map.put("name","name");
		map.put("marks","marks");
		map.put("email","email");
		DAOUtil.createProjection(criteria, map);
		Map studentMap=(Map)criteria.uniqueResult();
		session.close();
		return studentMap;
	}

}
