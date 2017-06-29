# StudentX

A command line application to load and filter Students

## Requirements

Java 8

Maven

A CSV file with the students information `[TYPE, NAME, GENDER, LAST_UPDATED_DATE]`(e.g.:`Kinder,Leia,F,20151231145934`)


## Build process

To build with tests run `mvn package`.
This will:

* Build the project - download dependencies
* Run all tests
* Create an executable jar in `target` called studentx-{version}.jar` where {version} is the current project version


## Running

### From Local Build result

Filter by student name
Run `java -jar studentx-{version}.jar [CSV_PATH] name=[STUDENT_NAME]`

Filter by student type
Run `java -jar studentx-{version}.jar [CSV_PATH] type=[STUDENT_TYPE]`

Filter by student type and gender
Run `java -jar studentx-{version}.jar [CSV_PATH] type=[STUDENT_TYPE] gender=[M|F]`

The gender parameter support only `M`(Male) and `F` (Female)

If you just want to start the spring application it will use the embedded tomcat and 8080 port
Run `java -jar studentx-{version}.jar`

## Notes
This version is only a command line application, RESTful services will be implemented in the version