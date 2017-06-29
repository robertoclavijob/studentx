package com.clavisoft.studentx.service;

import com.clavisoft.studentx.model.Student;

import java.io.File;
import java.util.List;

/**
 * Handle all the logic of request processing
 */
public interface StudentService {
    /**
     * Get students that match the parameters
     *
     * @param student
     * @return
     */
    public List<Student> filter(Student student);

    /**
     * Import a csv file to system
     *
     * @param file
     */
    public void importData(File file);
}
