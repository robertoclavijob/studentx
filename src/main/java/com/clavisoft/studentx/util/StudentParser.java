package com.clavisoft.studentx.util;

import com.clavisoft.studentx.constant.CLIParameter;
import com.clavisoft.studentx.constant.Gender;
import com.clavisoft.studentx.model.Student;

import java.util.List;

/**
 * Parse other formats to Student or Student to others
 */
public class StudentParser {
    private static final String PARAMETER_ASSIGNMENT = "=";

    /**
     * Parse string arguments based on CLI to a Student object
     *
     * @param args
     * @return
     */
    public static Student fromStringArguments(String[] args) {
        Student student = new Student();
        for (String arg : args) {
            if (arg.contains(PARAMETER_ASSIGNMENT)) {
                String parameter = arg.split(PARAMETER_ASSIGNMENT)[0];
                String value = arg.split(PARAMETER_ASSIGNMENT)[1];
                CLIParameter cliParameter = CLIParameter.fromString(parameter);
                switch (cliParameter) {
                    case NAME:
                        student.setName(value);
                        break;
                    case TYPE:
                        student.setType(value);
                        break;
                    case GENDER:
                        student.setGender(Gender.fromString(value));
                        break;
                }
            }
        }
        return student;
    }

    /**
     * Given a student collection is parse to string format
     *
     * @param students
     * @return
     */
    public static String parseStudentCollectionToString(List<Student> students) {
        String response;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Students info:\n");
        students.forEach(student -> {
            stringBuilder.append(String.format("studentId[%d], name[%s], type[%s], gender[%s], lastUpdate[%s] \n",
                    student.getStudentId(), student.getName(), student.getType(), student.getGender().toString(), student.getLastUpdate().toString()));
        });
        response = stringBuilder.toString();
        return response;
    }
}
