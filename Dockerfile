FROM openjdk:8
EXPOSE 9092
ADD target/*.jar .jar
ENTRYPOINT ["java","-jar","/EmployeeData-0.0.1-SNAPSHOT.jar"]