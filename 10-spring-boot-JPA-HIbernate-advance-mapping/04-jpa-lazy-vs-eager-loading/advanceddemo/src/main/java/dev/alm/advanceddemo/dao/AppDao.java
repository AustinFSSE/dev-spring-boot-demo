package dev.alm.advanceddemo.dao;

import dev.alm.advanceddemo.entity.Course;
import dev.alm.advanceddemo.entity.Instructor;
import dev.alm.advanceddemo.entity.InstructorDetail;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface AppDao {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    @Transactional
    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List <Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);

}
