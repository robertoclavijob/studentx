package com.clavisoft.studentx.util;

import com.clavisoft.studentx.constant.Gender;
import com.clavisoft.studentx.model.Student;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for Student Parser
 */
public class StudentParserTest {
    @Test
    public void testParseFromStringArguments(){
        String EXPECTED_NAME = "Roberto";
        Gender EXPECTED_GENDER = Gender.MALE;
        String EXPECTED_TYPE = "Kinder";
        String[] args = {"name=Roberto", "gender=M", "type=Kinder"};
        Student parsedStudent = StudentParser.fromStringArguments(args);
        assertEquals(EXPECTED_NAME, parsedStudent.getName());
        assertEquals(EXPECTED_GENDER, parsedStudent.getGender());
        assertEquals(EXPECTED_TYPE, parsedStudent.getType());
    }
}
