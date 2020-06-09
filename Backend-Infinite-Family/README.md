----
Task1-
Created APIs to save the student details(Age, id, name), fetch the details of student and Delete the student by Id. Enabled the
Swagger-ui for the apis
Following are the links of APIs

##Save the student:
http://localhost:8085/swagger-ui.html#/student-controller/saveStudentUsingPOST

##GetALLStudents
http://localhost:8085/swagger-ui.html#/student-controller/getStudentUsingGET

##Delete the students for Id
http://localhost:8085/swagger-ui.html#/student-controller/deleteStudentUsingDELETE

--------
Task2-
Created the APis to save the Person details(Id, Age, Name) along with the childrens along with Children of Children and Fetch the data with the help of Parent Id.Enabled the 
Swagger-ui for the apis:

##Save the Person details:
http://localhost:8085/swagger-ui.html#/person-controller/postToDBUsingPOST

##Fetching the details of the Person by Id:
http://localhost:8085/swagger-ui.html#/person-controller/findByIdUsingGET

Model to save the Person data:
{
  "age": 60,
  "name": "GrandFather",
  "children": [
    {
      "age": 20,
      "children": [
        {
          "age": 1,
          
          "name": "Son1"
          
        }
      ],
      
      "name": "father1"
      
    },
    {
      "age": 25,
      "children": [
        {
          "age": 3,
          
          "name": "Son2"
          
        }
      ],
      
      "name": "father2"
      
    },
   {
      "age": 30,
      "children": [
        {
          "age": 5,
          
          "name": "son3"
          
        }
      ],
      "name": "father3"
      
      
      
    }
  ] 
}
----
Database Used- Mysql
Library Used  = Spring Boot Java Persistence Library using hibernate, Spring Actuator is used to monitor the health of application.
Junit Coverage = Almost 50%;
-----
MySQL-JPA_Hibernate Properties-
##Port

server.port = 8085

##DataBase Connectivity URL

spring.datasource.url = jdbc:mysql://localhost:3306/personal
spring.datasource.username=root
spring.datasource.password=daka@1234

# Show or not log for each sql query
spring.jpa.show-sql = true

# Hibernate ddl auto (create, create-drop, update)
spring.jpa.hibernate.ddl-auto = create-drop

# Naming strategy
spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy

# Use spring.jpa.properties.* for Hibernate native properties (the prefix is
# stripped before adding them to the entity manager)

# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect






