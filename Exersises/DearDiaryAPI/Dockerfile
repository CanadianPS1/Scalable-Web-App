FROM maven:3.9-sapmachine-21 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
 
FROM tomcat:11.0.0-jdk21
#COPY --from=build /home/app/target/CSC280DearDiaryAPI.war /usr/local/tomcat/webapps/CSC280DearDiaryAPI.war
COPY --from=build /home/app/target/CSC280DearDiaryAPI.war /usr/local/tomcat/webapps/ROOT.war