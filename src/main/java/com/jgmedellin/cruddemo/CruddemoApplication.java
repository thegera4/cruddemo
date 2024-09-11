package com.jgmedellin.cruddemo;

import com.jgmedellin.cruddemo.dao.StudentDAO;
import com.jgmedellin.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) { //Executed after all beans are loaded
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryStudents(studentDAO);
			//queryStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};

	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student...");
		Student tempStudent = new Student("John", "Doe", "jdoe@email.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display the id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create the student objects
		System.out.println("Creating new students...");
		Student tempStudent1 = new Student("John", "Doe", "jdoe@email.com");
		Student tempStudent2 = new Student("Mary", "Public", "mpub@email.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bapp@email.com");

		// save the student objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void readStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating a student...");
		Student newStudent = new Student("Mary", "Public", "mpub@email.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(newStudent);

		//display the id of the saved student
		int theId = newStudent.getId();
		System.out.println("Saved student. Generated id: " + newStudent.getId());

		//retrieve the student object based on the id
		System.out.println("Getting student with id: " + theId);
		Student retrievedStudent = studentDAO.findById(theId);

		//display the retrieved student
		System.out.println("Found student: " + retrievedStudent);

	}

	private void queryStudents(StudentDAO studentDAO) {
		// get the list of students
		List<Student> theStudents = studentDAO.findAll();

		// display the students
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void queryStudentsByLastName(StudentDAO studentDAO) {
		// get the list of students
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		// display the students
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student theStudent = studentDAO.findById(studentId);

		// change the student's first name
		System.out.println("Updating student...");
		theStudent.setFirstName("John");

		// update the student
		studentDAO.update(theStudent);

		// display the updated student
		System.out.println("Updated student: " + theStudent);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		// delete student based on the id
		int studentId = 2;
		System.out.println("Deleting student with id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Number of rows deleted: " + numRowsDeleted);
	}

}