package com.clavisoft.studentx.dao;

import com.clavisoft.studentx.constant.Gender;
import com.clavisoft.studentx.exception.InvalidCSVException;
import com.clavisoft.studentx.model.Student;

import java.io.File;
import java.util.List;

/**
 * Database interaction
 */
public abstract class StudentDAO {
    /**
     * All persisted students
     */
    List<Student> storedStudents;

    /**
     * Parse a CSV file and import all students
     * Each CSV row should be defined as "Kinder,Leia,F,20151231145934"
     * The “Timestamp” format is: “<year><month><day><hour><minute><second>”, e.g.:
     * The representation for December 31st, 2013 14:59:34 is 20131231145934.
     *
     * @param csvFile The external resource
     */
    public abstract void importStudentsFromCSV(File csvFile) throws InvalidCSVException;

    /**
     * Create a given student
     *
     * @param student
     */
    public abstract void create(Student student);

    /**
     * Delete a given student
     *
     * @param student
     */
    public abstract void delete(Student student);

    /**
     * Look for all students filtering by name sorted alphabetically
     *
     * @return
     */
    public abstract List<Student> findByName();

    /**
     * Look for students filtering by type, sorted by date most recent to least recent
     *
     * @param type
     * @return
     */
    public abstract List<Student> findByType(String type);

    /**
     * Look for students filtering by gender and type, sorted by date most recent to least recent
     *
     * @param type
     * @return
     */
    public abstract List<Student> findByGenderAndType(Gender gender, String type);

    /**
     * Get all students
     *
     * @return
     */
    public abstract List<Student> getAll();

    /**
     * Remove all students
     */
    public abstract void removeAll();
}
