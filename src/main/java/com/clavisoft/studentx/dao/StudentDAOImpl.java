package com.clavisoft.studentx.dao;

import com.clavisoft.studentx.constant.Gender;
import com.clavisoft.studentx.data.SystemData;
import com.clavisoft.studentx.exception.InvalidCSVException;
import com.clavisoft.studentx.model.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Implement Student DAO methods
 */
public class StudentDAOImpl extends StudentDAO {
    private final String DATE_FORMAT = "yyyyMMddHHmmss";

    private final String SEPARATOR = ",";

    public StudentDAOImpl() {
        this.storedStudents = SystemData.getInstance().getStudentData();
    }

    /**
     * Parse a string to the format used in csv
     * @param date
     * @return
     */
    private Date parseStringDateFormat(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.DATE_FORMAT);
        Date formattedDate = null;
        try {
            formattedDate = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

    @Override
    public void importStudentsFromCSV(File csvFile) throws InvalidCSVException {
        Scanner scanner;
        try {
            scanner = new Scanner(csvFile);
            int i = 1;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
                String[] rowValues = line.split(this.SEPARATOR);
                // THE INDEX NUMBER IS HARD-CODED IN THE NEXT WAY
                // INDEX DETAIL:
                // 0 : TYPE
                // 1 : NAME
                // 2 : GENDER
                // 3 : LAST_UPDATE

                if (rowValues.length != 4) {
                    throw new InvalidCSVException("The CSV should contain at least 4 fields per row");
                }
                //TODO Look for a way to avoid hardcoding index of rowValues array

                Student student = new Student();
                student.setType(rowValues[0]);
                student.setName(rowValues[1]);
                student.setGender(Gender.fromString(rowValues[2]));
                student.setLastUpdate(this.parseStringDateFormat(rowValues[3]));
                student.setStudentId(i++);

                System.out.println(String.format("Student info: type[%s], name[%s], lastUpdate[%s], studentId[%d]",
                        student.getType(), student.getName(), student.getLastUpdate(), student.getStudentId()));
                this.create(student);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Student student) {
        storedStudents.add(student);
    }

    @Override
    public void delete(Student student) {
        Iterator<Student> iterator = storedStudents.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getStudentId().equals(student.getStudentId())) {
                iterator.remove();
            }
        }
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> filteredStudents = this.storedStudents.stream()
                .filter(student -> name.equals(student.getName()))
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
        return filteredStudents;
    }

    @Override
    public List<Student> findByType(String type) {
        List<Student> filteredStudents = this.storedStudents.stream()
                .filter(student -> type.equals(student.getType()))
                .sorted(Comparator.comparing(Student::getLastUpdate).reversed())
                .collect(Collectors.toList());
        return filteredStudents;
    }

    @Override
    public List<Student> findByGenderAndType(Gender gender, String type) {
        List<Student> filteredStudents = this.storedStudents.stream()
                .filter(student -> gender.equals(student.getGender()))
                .filter(student -> type.equals(student.getType()))
                .sorted(Comparator.comparing(Student::getLastUpdate).reversed())
                .collect(Collectors.toList());
        return filteredStudents;
    }

    @Override
    public List<Student> getAll() {
        return storedStudents;
    }

    @Override
    public void removeAll() {
        storedStudents.clear();
    }
}
