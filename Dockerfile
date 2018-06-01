FROM maven:3.5-jdk-10-slim AS builder
ADD . /app
WORKDIR /app
RUN mvn install -Dmaven.test.skip=true

FROM openjdk:10-slim
COPY --from=builder /app/target/mysim-0.0.1-SNAPSHOT.jar /app/mysim.jar
CMD ["java", "-jar", "/app/mysim.jar"]