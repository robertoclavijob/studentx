package com.clavisoft.studentx.dao;

import com.clavisoft.studentx.constant.Gender;
import com.clavisoft.studentx.data.SystemData;
import com.clavisoft.studentx.model.Student;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Implement Student DAO methods
 */
public class StudentDAOImpl extends StudentDAO {

    public StudentDAOImpl() {
        this.storedStudents = SystemData.getInstance().getStudentData();
    }

    @Override
    public void importStudentsFromCSV(File csvFile) {

    }

    @Override
    public void create(Student student) {
        storedStudents.add(student);
    }

    @Override
    public void delete(Student student) {
        Iterator<Student> iterator = storedStudents.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getStudentId().equals(student.getStudentId())) {
                iterator.remove();
            }
        }
    }

    @Override
    public List<Student> findByName() {
        return null;
    }

    @Override
    public List<Student> findByType(String type) {
        return null;
    }

    @Override
    public List<Student> findByGenderAndType(Gender gender, String type) {
        return null;
    }

    @Override
    public List<Student> getAll() {
        return storedStudents;
    }

    @Override
    public void removeAll() {
        storedStudents.clear();
    }
}
