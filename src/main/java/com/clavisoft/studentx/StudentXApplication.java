package com.clavisoft.studentx;

import com.clavisoft.studentx.cli.StudentCLIImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentXApplication {

	public static void main(String[] args) {
		if(args.length == 0){
			//TODO Handle the logs with log4j
			System.out.println("Starting StudentX Services");
			SpringApplication.run(StudentXApplication.class, args);
		}else{
			System.out.println("StudentX CLI");
			System.out.println(new StudentCLIImpl(args).filter());
		}
	}
}
