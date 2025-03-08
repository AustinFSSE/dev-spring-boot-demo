package dev.alm.cruddemo;

import dev.alm.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}
	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating student object!");
		Student student = new Student("Austin", "Martin", "amartin405@ivytech.edu");

		System.out.println("Saving student object!");
		studentDAO.save(student);

		System.out.println("Saved Student. Generated id: " + student.getId());
	}

}
