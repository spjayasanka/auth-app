@echo off
echo Downloading Spring Boot dependencies...

REM This is a simplified startup script
REM In a real scenario, you would need to download the Spring Boot JARs first

echo Compiling the application...
javac -d target -cp "src/main/java" src/main/java/com/example/authapp/*.java src/main/java/com/example/authapp/model/*.java src/main/java/com/example/authapp/service/*.java src/main/java/com/example/authapp/controller/*.java

echo Starting the application...
java -cp "target;src/main/resources" com.example.authapp.AuthAppApplication

pause