package dev.alm.advanceddemo.dao;

import dev.alm.advanceddemo.entity.Course;
import dev.alm.advanceddemo.entity.Instructor;
import dev.alm.advanceddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDao{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager em) {
        this.entityManager = em;
    }
    @Override
    @Transactional
    public void save(Instructor instructor) {

        entityManager.persist(instructor);
    }
    @Override
    public Instructor findInstructorById(int id){
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id){

        // retrieve the instructor
        Instructor instructor = findInstructorById(id);

        // get the courses
        List<Course> courses = instructor.getCourses();

        // break association with all courses for the instructor
        for (Course course : courses) {
            course.setInstructor(null);
        }

        // delete the instructor
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {

        InstructorDetail instructorDetail = findInstructorDetailById(id);

        // remove the associated object reference
        //
         // break the bidirectional link
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
        System.out.println("instructorDetail: " + instructorDetail + " deleted!");
    }

    @Override
    public List <Course> findCoursesByInstructorId(int id) {

        // create query
        TypedQuery <Course> query = entityManager.createQuery("from Course where instructor.id=:data", Course.class);
        query.setParameter("data", id);

        // execute query
        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
         //
         // This code below is similar to a FetchType.EAGER
         // meaning it will fetch the instructor and all the courses attached
         //
         // create query
        TypedQuery<Instructor> query = entityManager.createQuery(
                                                    "select i from Instructor i "
                                                    + " join fetch i.courses "
                                                    + " join fetch i.instructorDetail "
                                                    + " id where i.id=:data ", Instructor.class );

        query.setParameter("data", id);

        // execute query
        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }
}
