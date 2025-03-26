package dev.alm.advanceddemo;

import dev.alm.advanceddemo.dao.AppDao;
import dev.alm.advanceddemo.entity.Instructor;
import dev.alm.advanceddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvanceddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvanceddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao) {

        return runner -> createInstructor(appDao);
    }

    private void createInstructor(AppDao appDao) {

        /*Instructor instructor = new Instructor("Chad", "Darby", "email@gmail.com");

        InstructorDetail instructorDetail = new InstructorDetail(
                "https://www.luv2code.com/youtube",
                "Luv 2 code!!"
        );*/
        Instructor instructor = new Instructor("Austin", "Martin", "email@gmail.com");

        InstructorDetail instructorDetail = new InstructorDetail(
                "https://www.luv2code.com/youtube",
                "Coding"
        );
        // associate the objects
        instructor.setInstructorDetail(instructorDetail);

        // save the instructor
        // NOTE: this will ALSO save the details object
        // because of the CascadeType.ALL
        //
        appDao.save(instructor);

        System.out.println("Created Instructor: " + instructor);
    }

}
