package dev.alm.advanceddemo;

import dev.alm.advanceddemo.dao.AppDao;
import dev.alm.advanceddemo.entity.Course;
import dev.alm.advanceddemo.entity.Instructor;
import dev.alm.advanceddemo.entity.InstructorDetail;
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
//            createInstructor(appDao);
//            findInstructor(appDao);
//            deleteInstructor(appDao);
//            findInstructorDetail(appDao);
//            deleteInstructorDetail(appDao);
//            createInstructorWithCourses(appDao);
//            findInstructorWithCourses(appDao);
//            findCoursersForInstructor(appDao);
//            findInstructorWithCoursesJoinFetch(appDao);
//            updateInstructor(appDao);
//            updateCourse(appDao);
            deleteInstructor(appDao);

        };
    }

    private void updateCourse(AppDao appDao) {
        int id = 10;
        // find course
        Course course = appDao.findCourseById(id);
        System.out.println("Course: " + course);

        // change the course title
        System.out.println("Updating course...");
        course.setTitle("Java Spring - Masterclass");

        // execute the change
        appDao.update(course);

        System.out.println("Course: " + course);
        System.out.println("DONE!");
    }

    private void updateInstructor(AppDao appDao) {

        int id = 1;

        // find the instructor
        Instructor instructor = appDao.findInstructorById(id);
        System.out.println("Instructor: " + instructor);

        // change the instructor's last name
        instructor.setLastName("NotMartin");

        // execute the change
        appDao.update(instructor);

        // display new instructor data
        System.out.println("Instructor: " + instructor);
        System.out.println("Done!");
    }

    private void findInstructorWithCoursesJoinFetch(AppDao appDao) {

        int id = 1;

        // find the instructor
        System.out.println("finding instructor id: " + id);
        Instructor instructor = appDao.findInstructorByIdJoinFetch(id);

        System.out.println("found instructor: " + instructor);
        System.out.println("The associated courses: " + instructor.getCourses());

        System.out.println("Done!");
    }

    private void findCoursersForInstructor(AppDao appDao) {
        int instructorId = 1;
        System.out.println("Finding instructor with id: " + instructorId);

        Instructor instructor = appDao.findInstructorById(instructorId);
        System.out.println("Found instructor: " + instructor);

        // find courses for instructor
        System.out.println("Finding courses with id: " + instructorId);
        List <Course> courses = appDao.findCoursesByInstructorId(instructorId);

        // associate the objects
        instructor.setCourses(courses);

        System.out.println("Found courses: " + instructor.getCourses());
        System.out.println("Done");

    }

    private void findInstructorWithCourses(AppDao appDao) {
        int instructorId = 1;
        System.out.println("Finding instructor with id: " + instructorId);

        Instructor instructor = appDao.findInstructorById(instructorId);
        System.out.println("Found instructor: " + instructor);
        System.out.println("Finding courses with id: " + instructor.getCourses());

        System.out.println("Done!");
    }

    private void createInstructorWithCourses(AppDao appDao) {
        Instructor instructor = new Instructor("Chad", "Darby", "email@gmail.com");

        InstructorDetail instructorDetail = new InstructorDetail(
                "https://www.luv2code.com/youtube",
                "Luv 2 code!!"
        );
        // associate the objects
        instructor.setInstructorDetail(instructorDetail);

        // create some courses
        Course course = new Course("Java - Masterclass");
        Course course2 = new Course("React.js - Masterclass");
        Course course3 = new Course("MySQL - Masterclass");

        instructor.add(course);
        instructor.add(course2);
        instructor.add(course3);

        // saving the instructor

        System.out.println("Courses being saved to database...");
        System.out.println(instructor.getCourses());
        System.out.println("Saving instructor... " + instructor);
        appDao.save(instructor);
        System.out.println("Done!");

    }

    private void deleteInstructorDetail(AppDao appDao) {

        int id = 4;
        System.out.println("Delete Instructor detail id " + id);

        appDao.deleteInstructorDetailById(id);

        System.out.println("Done!");
    }

    private void findInstructorDetail(AppDao appDao) {

        // get the instructor detail object
        int id = 4;
        InstructorDetail instructorDetail = appDao.findInstructorDetailById(id);

        // print the instructor detail
        System.out.println("instructorDetail: " + instructorDetail);
        // print the associated instructor
        System.out.println("The associated instructor: " + instructorDetail.getInstructor());
        System.out.println("done");
    }

    private void deleteInstructor(AppDao appDao) {

        int id = 1;
        System.out.println("Deleting instructor with id: " + id);

        appDao.deleteInstructorById(id);
        System.out.println("Deleted");
    }

    private void findInstructor(AppDao appDao) {
        int id = 2;
        System.out.println("finding instructor with id " + id);

        Instructor instructor = appDao.findInstructorById(id);

        System.out.println("Instructor found: " + instructor);
        System.out.println("Instructor Detail only: " + instructor.getInstructorDetail());

    }

    private void createInstructor(AppDao appDao) {

        Instructor instructor = new Instructor("Chad", "Darby", "email@gmail.com");

        InstructorDetail instructorDetail = new InstructorDetail(
                "https://www.luv2code.com/youtube",
                "Luv 2 code!!"
        );
        Instructor instructor1 = new Instructor("Austin", "Martin", "email@gmail.com");

        InstructorDetail instructorDetail1 = new InstructorDetail(
                "https://www.luv2code.com/youtube",
                "Coding"
        );
        // associate the objects
        instructor.setInstructorDetail(instructorDetail);
        instructor1.setInstructorDetail(instructorDetail1);

        // save the instructor
        // NOTE: this will ALSO save the details object
        // because of the CascadeType.ALL
        //
        appDao.save(instructor);
        appDao.save(instructor1);

        System.out.println("Created Instructor: " + instructor);
        System.out.println("Created InstructorDetail: " + instructor1);
    }

}
