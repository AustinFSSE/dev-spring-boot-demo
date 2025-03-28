package dev.alm.cruddemo;

import dev.alm.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDOAImpl implements StudentDAO {

    private final EntityManager entityManager;

    @Autowired
    public StudentDOAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }
    @Override
    public List <Student> findAll() {
        TypedQuery <Student> query = entityManager.createQuery("FROM Student", Student.class);
        return query.getResultList();
    }

    @Override
    public List <Student> findByLastName(String lastName) {

        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName = :lastName", Student.class);

        query.setParameter("lastName", lastName);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
         Student student = entityManager.find(Student.class, id);
         entityManager.remove(student);

    }

    @Override
    @Transactional
    public int delateAll() {

        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
