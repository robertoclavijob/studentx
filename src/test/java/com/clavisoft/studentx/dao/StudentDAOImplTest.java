package com.clavisoft.studentx.dao;

import com.clavisoft.studentx.constant.Gender;
import com.clavisoft.studentx.exception.InvalidCSVException;
import com.clavisoft.studentx.model.Student;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
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
        assertEquals(1, studentDAO.getAll().size());
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
        assertEquals(0, studentDAO.getAll().size());
    }

    @Test
    public void testImportStudentsFromCSV() throws InvalidCSVException{
        File csvFile = new File(getClass().getResource("/input.csv").getFile());
        studentDAO.importStudentsFromCSV(csvFile);
        assertEquals(10, studentDAO.getAll().size());
    }

    @Test
    public void testFindByName() throws InvalidCSVException {
        String NAME_TO_FIND = "Leia";
        File csvFile = new File(getClass().getResource("/input.csv").getFile());
        studentDAO.importStudentsFromCSV(csvFile);
        assertEquals(1, studentDAO.findByName(NAME_TO_FIND).size());
    }

    @Test
    public void testFindByType() throws InvalidCSVException {
        String TYPE_TO_FIND = "Kinder";
        File csvFile = new File(getClass().getResource("/input.csv").getFile());
        studentDAO.importStudentsFromCSV(csvFile);
        assertEquals(5, studentDAO.findByType(TYPE_TO_FIND).size());
    }

    @Test
    public void testFindByGenderAndType() throws InvalidCSVException {
        String TYPE_TO_FIND = "Kinder";
        File csvFile = new File(getClass().getResource("/input.csv").getFile());
        studentDAO.importStudentsFromCSV(csvFile);
        assertEquals(2, studentDAO.findByGenderAndType(Gender.FEMALE, TYPE_TO_FIND).size());
    }

    @After
    public void cleanUp(){
        studentDAO.removeAll();
    }
}
