package dev.alm.advanceddemo;

import dev.alm.advanceddemo.dao.AppDao;
import dev.alm.advanceddemo.entity.Course;
import dev.alm.advanceddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdvanceddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvanceddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao) {

        return runner -> {

            // createCourseAndStudents(appDao);
            // findCourseAndStudents(appDao);
            // findStudentAndCourses(appDao);
            // addMoreCoursesForStudent(appDao);
            // deleteCourse(appDao);
            deleteStudent(appDao);

        };
    }

    private void deleteStudent(AppDao appDao) {

        int studentId = 1;
        appDao.deleteStudentById(studentId);
        System.out.println("Done!");
    }

    private void deleteCourse(AppDao appDao) {
        int id = 15;
        System.out.println("Deleting course with id " + id);
        appDao.deleteCourseById(id);
        System.out.println("done!");
    }

    private void addMoreCoursesForStudent(AppDao appDao) {

        int studentId = 2;
        Student student = appDao.findStudentAndCoursesByStudentId(studentId);
        System.out.println("Student with id " + studentId + " is " + student);

        // create more courses
        Course course = new Course("Java - Intermediate Level");
        Course course1 = new Course("Java - Advanced Level");

        student.addCourse(course);
        student.addCourse(course1);

        System.out.println("Courses added: " + student.getCourses());

        appDao.update(student);

        System.out.println("Done!");
    }

    private void findStudentAndCourses(AppDao appDao) {

        int studentId = 1;
        Student student = appDao.findStudentAndCoursesByStudentId(studentId);

        System.out.println("Loaded student: " + student);
        System.out.println("Loaded associated courses: " + student.getCourses());

        System.out.println("Done!");
    }

    private void findCourseAndStudents(AppDao appDao) {

        int id = 10;
        Course course = appDao.findCourseAndStudentsByCourseId(id);
        System.out.println("Course " + course);
        System.out.println("Associated Student(s) " + course.getStudents());

        System.out.println("Done!");
    }

    private void createCourseAndStudents(AppDao appDao) {

        // create Course
        Course course = new Course("Java SpringBoot - Beginner Level");

        // create student
        Student student = new Student("John", "Doe","john@doe.com");
        Student student1 = new Student("Jane", "NOTDoe","jane@doe.com");
        Student student2 = new Student("Billy", "BOB","notBilly@doe.com");

        // add student to the course
        course.addStudent(student);
        course.addStudent(student1);
        course.addStudent(student2);

        // save the course and associate students
        System.out.println("Saving the course: " + course);
        System.out.println("Saving the associated students: " + course.getStudents());

        // save the data to database
        appDao.save(course);

        System.out.println("DONE!");

    }


}
