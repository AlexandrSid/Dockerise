#where to get this versions to copy?
#which one is better option for me
#is the key-words key-sensitive?
#FROM jdk-15.0.2_7-alpine doesn't work
#FROM java:11 tozhe nihuya
FROM openjdk:11

WORKDIR /app

#who will pack the application to .jar? maven? javac? 
#what will happen if there will not be asembled file?
COPY ./target/Dockerise-1.0-SNAPSHOT.jar /dockerise.jar

#startup command to execute jar
#i have never done this before in such a way, have no idea what's going on
CMD ["java", "-jar", "/dockerise.jar"]

ck
