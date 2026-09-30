FROM eclipse-temurin:17-jre
WORKDIR /app
COPY dist/simple-java-ant-app.jar app.jar
CMD ["java", "-jar", "app.jar"]
