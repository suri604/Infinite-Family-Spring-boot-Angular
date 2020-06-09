PROBLEM STATEMENT:
1.	Create an API that saves the name of the person, parentId, age. A unique Id should be created for each record.
2.	Create sample data like 3 persons. Each person will be having 3 children and then each child will be having 3 children again as shown in the figure.
3.	Create a screen having a simple form for age, name and save it to the DB using the API developed above.
4.	A screen with search input where I can give the parentId and it should fetch the record from the db using the API developed above and display it in the UI in whatever format you like. You can just display all the children and children of children in some better format you can think of.



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
spring.jpa.hibernate.ddl-auto = update

# Naming strategy
spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy

# Use spring.jpa.properties.* for Hibernate native properties (the prefix is
# stripped before adding them to the entity manager)

# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect

---
# Time Complexity:





