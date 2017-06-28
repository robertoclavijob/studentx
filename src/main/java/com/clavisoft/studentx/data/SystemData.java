package com.clavisoft.studentx.data;
import com.clavisoft.studentx.model.Student;

import java.util.ArrayList;
import java.util.List;
/**
 * This class will only handle all database records in memory
 */
public class SystemData {
    private static List<Student> studentData = new ArrayList<>();
    private static SystemData instance;
    private SystemData(){
    }
    /**
     * A Singleton instance, synchronized to be thread safe
     * @return
     */
    public static synchronized SystemData getInstance(){
        if(instance == null){
            instance = new SystemData();
        }
        return instance;
    }
    /**
     * Wrap all student records
     * @return
     */
    public List<Student> getStudentData() {
        return studentData;
    }
}
