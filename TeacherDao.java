package com.ty_one_to_many_uni_School.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty_one_to_many_uni_School.dto.School;
import com.ty_one_to_many_uni_School.dto.Student;
import com.ty_one_to_many_uni_School.dto.Teacher;

public class TeacherDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveTeacher(List<Teacher> teacher) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		for (Teacher t : teacher) {
			entityTransaction.begin();
			entityManager.persist(t);
			entityTransaction.commit();
		}
	}

	public void updateTeacher(int id, Teacher teacher) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Teacher recivedTeacher = entityManager.find(Teacher.class, id);
		if (recivedTeacher != null) {
			entityTransaction.begin();
			recivedTeacher.setId(id);
			recivedTeacher.setAddress(teacher.getAddress());
			entityManager.merge(recivedTeacher);
			entityTransaction.commit();
		} else {
			System.out.println("Teacher Does Not Exist");
		}
	}

	public void deleteTeacher(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Teacher teacher = entityManager.find(Teacher.class, id);
		entityTransaction.begin();
		entityManager.remove(teacher);
		entityTransaction.commit();
	}
	public void getTeacherById(int id) {
		EntityManager entityManager = getEntityManager();
		Teacher teacher = entityManager.find(Teacher.class, id);	
		System.out.println(teacher);		
	}
	
	public void getAllTeacher() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select t from Teacher t");
		List<Teacher> list = query.getResultList();
		System.out.println(list);
	}
}
