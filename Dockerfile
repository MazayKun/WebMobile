FROM tomcat:9-jdk8
COPY  target/Mobile-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/Mobile-1.0-SNAPSHOT.war
EXPOSE 8080