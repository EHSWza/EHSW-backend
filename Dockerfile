FROM gradle:8-jdk-alpine AS builder
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY gradle ./gradle
RUN gradle build --no-daemon --refresh-dependencies || true
COPY src ./src
RUN ./gradlew clean build --no-daemon

FROM eclipse-temurin:8-jdk-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]