FROM docker.io/eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY gradle/ gradle/
COPY gradlew build.gradle ./
COPY src ./src
COPY prospects.txt ./

RUN ./gradlew build

CMD ["./gradlew", "bootRun"]