package com.student.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import com.student.dto.Student;


@Repository
public class StudentDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");

	EntityManager em = emf.createEntityManager();

	EntityTransaction et = em.getTransaction();

	public void saveStudent(Student student) {
		et.begin();
		em.persist(student);
		et.commit();
	}

	public void updateStudent(Student student) {
		et.begin();
		em.merge(student);
		et.commit();
	}

	public void deleteStudent(Student student) {
		et.begin();
		em.remove(student);
		et.commit();
	}

	public Student findStudentById(int studentId) {
		Student student = em.find(Student.class, studentId);
		return student;
	}


	public List<Student> findAllStudents()
	{
		Query query= em.createQuery("select s from Student s");
		List<Student> students =query.getResultList();
		return students;
	}

}
