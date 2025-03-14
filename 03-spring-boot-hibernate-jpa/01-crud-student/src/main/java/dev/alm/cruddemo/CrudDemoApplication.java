package dev.alm.cruddemo;

import dev.alm.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
//			readStudent(studentDAO);
//			updateStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			removeStudent(studentDAO);
//			deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		System.out.println("Total students: " + students.size());
		for (Student student : students) {
			System.out.println(student + " ---> deleted");
			studentDAO.delete(student.getId());
		}
	}
	private void removeStudent(StudentDAO studentDAO) {

		int studentId = 4;
		Student student = studentDAO.findById(studentId);

		System.out.println("Removing --> " + student + " from our database");

		studentDAO.delete(studentId);

	}
	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating first student object!");
		Student student = new Student("Austin", "Martin", "amartin405@ivytech.edu");

		System.out.println("Saving first student object!");
		studentDAO.save(student);

		System.out.println("Creating second student object!");
		Student student1 = new Student("Alonah", "Martin", "alonahmartin@ivytech.edu");

		System.out.println("Saving second student object!");
		studentDAO.save(student1);

		System.out.println("Creating third student object!");
		Student student2 = new Student("Austin", "Martin", "amartin405@ivytech.edu");

		System.out.println("Saving third student object!");
		studentDAO.save(student2);

		int theID = student.getId();
		System.out.println("Saved Student. Generated id: " + theID);



	}
	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object!");
		Student student = new Student("Alonah", "Martin", "alonahmartin@ivytech.edu");

		System.out.println("Saving student object!");
		studentDAO.save(student);

		System.out.println("Saved Student. Generated id: " + student.getId());

		int theID = student.getId();
		System.out.println("Retrieving student id " + theID);
		Student retrievedStudent = studentDAO.findById(theID);

		System.out.println("Retrieved student id: " + retrievedStudent);

	}
	private void updateStudent(StudentDAO studentDAO) {

		int studentID = 2;
		System.out.println("Getting Student with id " + studentID);
		Student student = studentDAO.findById(studentID);

		System.out.println("Updating student with id " + studentID);
		student.setFirstName("NotAlonah");

		 studentDAO.update(student);
		 System.out.println("Student with id " + studentID + " updated --> " + student);
	}
	private void queryForStudents(StudentDAO studentDAO) {

		List <Student> students = studentDAO.findAll();
		System.out.println("Retrieving all students!");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		List<Student> students = studentDAO.findByLastName("Martin");
		System.out.println("Retrieving all students!");
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
