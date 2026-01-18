FROM gradle:8-jdk-jammy AS builder
WORKDIR /app
COPY gradlew .
COPY build.gradle settings.gradle ./
COPY gradle ./gradle
COPY src ./src
RUN chmod +x gradlew
RUN ./gradlew clean build --no-daemon --refresh-dependencies

FROM eclipse-temurin:8-jdk-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
