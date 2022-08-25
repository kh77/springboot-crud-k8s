FROM openjdk:8
EXPOSE 8080
ADD target/crud-k8s.jar crud-k8s.jar
ENTRYPOINT ["java","-jar","/crud-k8s.jar"]