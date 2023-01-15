package com.ty_one_to_many_uni_School.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty_one_to_many_uni_School.dto.School;
import com.ty_one_to_many_uni_School.dto.Teacher;

public class SchoolDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public boolean saveSchool(School school) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		School school2 = entityManager.find(School.class, school.getId());
		if (school2 == null) {
			entityTransaction.begin();
			school.setId(school.getId());

			entityManager.merge(school);
			entityTransaction.commit();
		} else {
			System.out.println("Id already exists");
		}
		return school2 == null;
	}

	public void updateSchool(int id, School school) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		School recivedSchool = entityManager.find(School.class, id);
		if (recivedSchool != null) {
			entityTransaction.begin();
			recivedSchool.setId(id);
			recivedSchool.setName(school.getName());
			entityManager.merge(recivedSchool);
			entityTransaction.commit();
		} else {
			System.out.println("School Does Not Exist");
		}
	}

	public void deleteSchool(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		School school = entityManager.find(School.class, id);
		entityTransaction.begin();
		entityManager.remove(school);
		entityTransaction.commit();
	}

	public void getSchoolById(int id) {
		EntityManager entityManager = getEntityManager();
		School school = entityManager.find(School.class, id);
		System.out.println(school);
	}

}
