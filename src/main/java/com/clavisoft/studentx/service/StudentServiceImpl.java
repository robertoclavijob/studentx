package com.clavisoft.studentx.service;

import com.clavisoft.studentx.constant.Gender;
import com.clavisoft.studentx.constant.StudentFilterType;
import com.clavisoft.studentx.dao.StudentDAO;
import com.clavisoft.studentx.dao.StudentDAOImpl;
import com.clavisoft.studentx.exception.InvalidCSVException;
import com.clavisoft.studentx.model.Student;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * Student service implementation
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> filter(Student student) {
        List<Student> result = null;
        StudentDAO studentDAO = new StudentDAOImpl();
        switch (this.defineFilterType(student)) {
            case BY_NAME:
                result = studentDAO.findByName(student.getName());
                break;
            case BY_TYPE:
                result = studentDAO.findByType(student.getType());
                break;
            case BY_GENDER_AND_TYPE:
                result = studentDAO.findByGenderAndType(student.getGender(), student.getType());
                break;
        }
        return result;
    }

    @Override
    public void importData(File file) {
        StudentDAO studentDAO = new StudentDAOImpl();
        try {
            studentDAO.importStudentsFromCSV(file);
        } catch (InvalidCSVException e) {
            e.printStackTrace();
        }
    }

    /**
     * Based on the student fields define what query execute
     *
     * @param student
     * @return
     */
    private StudentFilterType defineFilterType(Student student) {
        String name = student.getName();
        String type = student.getType();
        Gender gender = student.getGender();
        StudentFilterType studentFilterType = null;

        if (name != null && type == null && gender == null) {
            studentFilterType = StudentFilterType.BY_NAME;
        }
        if (name == null && type != null && gender == null) {
            studentFilterType = StudentFilterType.BY_TYPE;
        }
        if (name == null && type != null && gender != null) {
            studentFilterType = StudentFilterType.BY_GENDER_AND_TYPE;
        }
        return studentFilterType;
    }
}
