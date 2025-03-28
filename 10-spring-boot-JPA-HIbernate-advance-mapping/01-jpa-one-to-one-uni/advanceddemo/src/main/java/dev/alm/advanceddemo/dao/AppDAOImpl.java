package dev.alm.advanceddemo.dao;

import dev.alm.advanceddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    @Override
    public void deleteInstructorById(int id){

        // retrieve the instructor
        Instructor instructor = findInstructorById(id);

        // delete the instructor
        entityManager.remove(instructor);
    }
}
