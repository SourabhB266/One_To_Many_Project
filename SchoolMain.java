package com.ty_one_to_many_uni_School.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ty_one_to_many_uni_School.dao.SchoolDao;
import com.ty_one_to_many_uni_School.dao.StudentDao;
import com.ty_one_to_many_uni_School.dao.TeacherDao;
import com.ty_one_to_many_uni_School.dto.School;
import com.ty_one_to_many_uni_School.dto.Student;
import com.ty_one_to_many_uni_School.dto.Teacher;

public class SchoolMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Enter choice \n1:save school \n2:Update school \n3:remove school \n4:getAllSchool \n5:get student \n6:get teacher");
		int choice = scanner.nextInt();
		StudentDao dao = new StudentDao();
		TeacherDao dao2 = new TeacherDao();
		SchoolDao dao3 = new SchoolDao();
		School school = new School();
		List<Teacher> tlist = new ArrayList<Teacher>();
		List<Student> slist = new ArrayList<Student>();
		switch (choice) {
		case 1: {

			boolean b = true;
			boolean c = true;
			while (c) {
				System.out.println("Enter teacher name");
				String tname = scanner.next();
				System.out.println("Enter teacher address");
				String taddress = scanner.next();
				Teacher t1 = new Teacher();
				t1.setName(tname);
				t1.setAddress(taddress);

				tlist.add(t1);

				System.out.println("Enter true to add another teacher \nEnter false to exit");
				c = scanner.nextBoolean();
			}
			while (b) {
				System.out.println("Enter the student details");

				System.out.println("Enter name");
				String name = scanner.next();
				System.out.println("Enter Father name");
				String fatherName = scanner.next();
				System.out.println("Enter Address name");
				String address1 = scanner.next();
				Student s2 = new Student();
				s2.setName(name);
				s2.setFather_name(fatherName);
				s2.setAddress(address1);
				System.out.println("Enter true to add another student \nEnter false to exit");
				b = scanner.nextBoolean();

				slist.add(s2);

			}

			System.out.println("Enter id");
			int id = scanner.nextInt();
			System.out.println("Enter school name");
			String schoolName = scanner.next();
			System.out.println("Enter address ");
			String address = scanner.next();
			school.setName(schoolName);
			school.setId(id);
			school.setAddress(address);
			school.setTlist(tlist);
			school.setSlist(slist);

			dao2.saveTeacher(tlist);

			dao.saveStudent(slist);
			dao3.saveSchool(school);

			break;
		}
		
		case 2: {
			System.out.println("Enter choice to update \n1:teacher address \n2:Student address \n3:school name");
			int choice1 = scanner.nextInt();
			switch (choice1) {
			case 1: {
				Teacher teacher = new Teacher();
				System.out.println("Enter id");
				int id = scanner.nextInt();
				System.out.println("Enter address ");
				String address = scanner.next();
				teacher.setId(id);
				teacher.setAddress(address);
				dao2.updateTeacher(id, teacher);
			}
				break;// end case
			case 2: {
				Student student = new Student();
				System.out.println("Enter id");
				int id = scanner.nextInt();
				System.out.println("Enter address ");
				String address = scanner.next();
				student.setId(id);
				student.setAddress(address);
				dao.updateStudent(id, student);
			}
				break; // end case
			case 3: {
				System.out.println("Enter id");
				int id = scanner.nextInt();
				System.out.println("Enter name to change ");
				String name = scanner.next();
				school.setId(id);
				school.setName(name);
				dao3.updateSchool(id, school);
			} // end case
			}// switch end

		}
			break;
			
		case 3: {
			System.out.println("Enter choice to delete \n1:delete student   \n2:delete teacher \n3:delete school");
			int choice2 = scanner.nextInt();
			switch (choice2) {
			case 1: {
				System.out.println("Enter id of student");
				int id = scanner.nextInt();
				dao.deleteStudent(id);
			}
				break;// end case
			case 2: {
				System.out.println("Enter id of teacher");
				int id = scanner.nextInt();
				dao2.deleteTeacher(id);
			}
				break;// end case
			case 3: {
				System.out.println("Enter id of school");
				int id = scanner.nextInt();
				dao3.deleteSchool( id);
			}
				break;// end case
			}// end choice

		}
			break;// end case
		case 4: {
			System.out.println("Enter to get school by id");
			System.out.println("Enter id of school");
			int id = scanner.nextInt();
			dao3.getSchoolById(id);
		}
			break;// end case
		case 5: {
			dao.getAllStudent();
		}
			break; // end case
		case 6: {
			dao2.getAllTeacher();
		}
		}
		
	
	}

}
