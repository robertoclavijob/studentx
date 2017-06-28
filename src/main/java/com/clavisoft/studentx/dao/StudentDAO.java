package com.clavisoft.studentx.dao;

import com.clavisoft.studentx.constant.Gender;
import com.clavisoft.studentx.model.Student;

import java.io.File;
import java.util.List;

/**
 * Database interaction
 */
public interface StudentDAO {
    /**
     * Parse a CSV file and import all students
     *
     * @param csvFile The external resource
     */
    public void importStudentsFromCSV(File csvFile);

    /**
     * Create a given student
     *
     * @param student
     */
    public void create(Student student);

    /**
     * Delete a given student
     *
     * @param student
     */
    public void delete(Student student);

    /**
     * Look for all students filtering by name sorted alphabetically
     *
     * @return
     */
    public List<Student> findByName();

    /**
     * Look for students filtering by type, sorted by date most recent to least recent
     *
     * @param type
     * @return
     */
    public List<Student> findByType(String type);

    /**
     * Look for students filtering by gender and type, sorted by date most recent to least recent
     *
     * @param type
     * @return
     */
    public List<Student> findByGenderAndType(Gender gender, String type);
}
