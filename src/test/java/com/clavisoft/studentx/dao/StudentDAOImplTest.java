package com.clavisoft.studentx.dao;

import com.clavisoft.studentx.constant.Gender;
import com.clavisoft.studentx.model.Student;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Test StudentDAO methods
 */
public class StudentDAOImplTest {
    private static StudentDAO studentDAO;

    @BeforeClass
    public static void setUp(){
        studentDAO = new StudentDAOImpl();
    }
    @Test
    public void testCreate(){
        Student student = new Student();
        student.setStudentId(1);
        student.setType("Kinder");
        student.setName("Leia");
        student.setGender(Gender.FEMALE);
        student.setLastUpdate(new Date());
        studentDAO.create(student);
        assertEquals(studentDAO.getAll().size(), 1);
    }

    @Test
    public void testDelete(){
        Student student = new Student();
        student.setStudentId(1);
        student.setType("Kinder");
        student.setName("Leia");
        student.setGender(Gender.FEMALE);
        student.setLastUpdate(new Date());
        studentDAO.create(student);
        studentDAO.delete(student);
        assertEquals(studentDAO.getAll().size(), 0);
    }

    @After
    public void cleanUp(){
        studentDAO.removeAll();
    }
}
