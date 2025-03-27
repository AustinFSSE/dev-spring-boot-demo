package dev.alm.advanceddemo.dao;

import dev.alm.advanceddemo.entity.Instructor;
import dev.alm.advanceddemo.entity.InstructorDetail;
import org.springframework.transaction.annotation.Transactional;


public interface AppDao {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    @Transactional
    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
