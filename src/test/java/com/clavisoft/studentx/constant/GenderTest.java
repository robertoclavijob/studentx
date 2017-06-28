package com.clavisoft.studentx.constant;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Gender tests
 */
public class GenderTest {
    @Test
    public void testFromString(){
        assertEquals(Gender.FEMALE, Gender.fromString("F"));
        assertEquals(Gender.MALE, Gender.fromString("M"));
    }
}
