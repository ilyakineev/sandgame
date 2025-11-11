# Используем легковесный JDK
FROM eclipse-temurin:21-jre-alpine

# Копируем JAR в контейнер
COPY build/libs/*.jar sandgame.jar

# Команда запуска
ENTRYPOINT ["java", "-jar", "/sandgame.jar"]
