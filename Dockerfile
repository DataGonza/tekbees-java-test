FROM maven:3.9-amazoncorretto-11

WORKDIR /application
COPY . .
RUN mvn clean install
EXPOSE 8080

CMD [ "-jar", "target/microservices-0.0.1-SNAPSHOT.jar" ]
ENTRYPOINT [ "java" ]