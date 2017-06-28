package com.clavisoft.studentx.model;

import com.clavisoft.studentx.constant.Gender;

import java.util.Date;

/**
 * Student information wrapper
 */
public class Student {
    /**
     * This "type" field can have multiple types, so it is not an enum
     */
    private Integer studentId;
    private String type;
    private String name;
    private Gender gender;
    private Date lastUpdate;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
