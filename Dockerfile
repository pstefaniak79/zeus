#FROM openjdk:8u191-jdk-alpine3.9
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
FROM tomcat:9.0.39-jdk8
MAINTAINER pstefaniak79
COPY target/zeus-0.0.3-SNAPSHOT.war /usr/local/tomcat/webapps/
RUN mkdir -p /usr/local/tomcat/conf/zeus/db
RUN mkdir -p /usr/local/tomcat/conf/zeus/vault
#RUN mkdir -p /usr/local/tomcat/conf/zeus/config
COPY docker/auth.properties /usr/local/tomcat/conf/zeus/db
ENV CATALINA_OPTS='-Dconfig.sys=/usr/local/tomcat/conf/zeus/db/auth.properties -Dspring.config.location=/usr/local/tomcat/conf/zeus/config/application.properties'
EXPOSE 8080
CMD ["catalina.sh", "run"]