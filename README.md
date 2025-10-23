# Authentication App

A simple Spring Boot application with user registration and login functionality. This app features:

- User registration with username, email, and password
- User login with validation
- MySQL database for user storage
- Clean, minimal UI using Bootstrap

## Features

- Registration page with form validation
- Login page with authentication
- Dashboard after successful login
- Session-based authentication
- Logout functionality

## Project Structure

```
auth-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/authapp/
│   │   │       ├── AuthAppApplication.java
│   │   │       ├── controller/
│   │   │       │   └── AuthController.java
│   │   │       ├── model/
│   │   │       │   └── User.java
│   │   │       ├── repository/
│   │   │       │   └── UserRepository.java
│   │   │       └── service/
│   │   │           └── UserService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── templates/
│   │           ├── login.html
│   │           ├── register.html
│   │           └── dashboard.html
│   └── test/
│       └── java/
└── pom.xml
```

## Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher
- MySQL 8.0 or higher

## Database Setup

1. Create a MySQL database named `authapp`
2. Ensure MySQL is running on default port 3306
3. Update the database credentials in `application.properties` if needed (default: root user with no password)

## Running the Application

### Using Maven (Recommended)
1. Navigate to the project directory: `cd auth-app`
2. Run the application: `mvn spring-boot:run`
3. Open your browser and go to `http://localhost:8080`

### Using Gradle
1. Navigate to the project directory: `cd auth-app`
2. Run the application: `./gradlew bootRun` (or `gradlew.bat bootRun` on Windows)
3. Open your browser and go to `http://localhost:8080`

## How to Use

1. Go to the registration page (`/register`) to create a new account
2. Fill in the username, email, and password fields
3. After successful registration, go to the login page (`/login`)
4. Enter your credentials to access the dashboard
5. Use the logout button to end your session

## Technical Details

- MySQL database with JPA/Hibernate for persistence
- Session management for authentication
- Thymeleaf templating engine for views
- Bootstrap for responsive UI
- Spring Boot auto-configuration
- User input validation with annotations