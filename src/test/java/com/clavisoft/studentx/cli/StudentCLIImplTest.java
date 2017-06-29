package com.clavisoft.studentx.cli;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Student CLI Tests
 */
public class StudentCLIImplTest {
    public File csvFile = new File(getClass().getResource("/input.csv").getFile());
    @Test
    public void testSuccessValidateParameters(){
        String[] args = {csvFile.getAbsolutePath(), "name=leia"};
        StudentCLIImpl studentCLIImpl = new StudentCLIImpl(args);
        assertNull(studentCLIImpl.validateParameters());
    }

    @Test
    public void testIncorrectValidateParameters(){
        String[] args = {csvFile.getAbsolutePath(), "lastUpdate=leia"};
        StudentCLIImpl studentCLIImpl = new StudentCLIImpl(args);
        assertNotNull(studentCLIImpl.validateParameters());
    }

    @Test
    public void testMixedValidateParameters(){
        String[] args = {csvFile.getAbsolutePath(), "name=leia", "lastUpdate="};
        StudentCLIImpl studentCLIImpl = new StudentCLIImpl(args);
        assertNotNull(studentCLIImpl.validateParameters());
    }

    @Test
    public void testFilter(){
        String[] args = {csvFile.getAbsolutePath(), "name=Leia"};
        StudentCLIImpl studentCLIImpl = new StudentCLIImpl(args);
        assertNotNull(studentCLIImpl.filter());
    }
}
