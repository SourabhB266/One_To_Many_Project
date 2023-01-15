package com.ty_one_to_many_uni_School.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty_one_to_many_uni_School.dto.Student;
import com.ty_one_to_many_uni_School.dto.Teacher;

public class StudentDao {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void saveStudent(List<Student> student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		for(Student s:student) {
			entityTransaction.begin();
			entityManager.persist(s);
			entityTransaction.commit();
		}
	}
	public void updateStudent(int id, Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Student recivedStudent = entityManager.find(Student.class, id);
		if (recivedStudent != null) {
			entityTransaction.begin();
			recivedStudent.setId(id);
			recivedStudent.setAddress(student.getAddress());
			entityManager.merge(recivedStudent);
			entityTransaction.commit();
		} else {
			System.out.println("Student Does Not Exist");
		}
	}
	
	public void deleteStudent(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Student student = entityManager.find(Student.class, id);
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
	}
	public void getStudentById(int id) {
		EntityManager entityManager = getEntityManager();
		Student student = entityManager.find(Student.class, id);	
		System.out.println(student);		
	}
	public void getAllStudent() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select s from Student s");
		List<Teacher> list = query.getResultList();
		System.out.println(list);
	}
}
