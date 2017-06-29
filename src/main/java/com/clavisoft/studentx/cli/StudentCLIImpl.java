package com.clavisoft.studentx.cli;

import com.clavisoft.studentx.model.Student;
import com.clavisoft.studentx.service.StudentService;
import com.clavisoft.studentx.service.StudentServiceImpl;
import com.clavisoft.studentx.util.StudentParser;

import java.io.File;
import java.util.List;

/**
 * This CLI will work with the arguments that the client send
 */
public class StudentCLIImpl extends StudentCLI {

    private final String NAME_PARAMETER = "name=";
    private final String TYPE_PARAMETER = "type=";
    private final String GENDER_PARAMETER = "gender=";
    private final String DATA_EXTENSION = ".csv";
    private final String EXAMPLE = "input.csv name=Roberto";

    public StudentCLIImpl(String args[]) {
        this.args = args;
    }

    @Override
    protected String validateParameters() {
        String error = null;
        StringBuilder stringBuilder = new StringBuilder();
        for (String arg : this.args) {
            if (!arg.startsWith(this.NAME_PARAMETER) && !arg.startsWith(this.TYPE_PARAMETER) &&
                    !arg.startsWith(this.GENDER_PARAMETER) && !arg.endsWith(this.DATA_EXTENSION)) {
                stringBuilder.append(String.format("Incorrect input [%s]", arg));
                stringBuilder.append("\n");
                stringBuilder.append(String.format("You can use only [%s][%s][%s] parameters and a [%s] path. " +
                                "\n Example: [%s]",
                        this.NAME_PARAMETER, this.TYPE_PARAMETER, this.GENDER_PARAMETER, this.DATA_EXTENSION, this.EXAMPLE));
                error = stringBuilder.toString();
                System.out.println(error);
                return error;
            }
        }

        //Validate the csv path
        if(error==null){
            String filePath = args[0];
            if(!new File(filePath).exists()){
                error = String.format("[%s] does not exist", filePath);
            }
        }
        return error;
    }

    @Override
    public String filter() {
        String response = this.validateParameters();
        if (response == null) {
            StudentService studentService = new StudentServiceImpl();
            studentService.importData(new File(args[0]));
            List<Student> result = studentService.filter(StudentParser.fromStringArguments(args));
            response = StudentParser.parseStudentCollectionToString(result);
        }
        return response;
    }
}
