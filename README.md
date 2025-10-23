# Authentication App

A Spring Boot application with user registration and login functionality using Spring Security and JWT tokens. This app features:

- User registration with username, email, and password (passwords are BCrypted)
- User login with JWT token authentication
- MySQL database for user storage
- Clean, minimal UI using Bootstrap
- API endpoints for authentication with JWT tokens
- Web pages for traditional session-based authentication

## Features

- Registration page with form validation
- Login page with authentication
- Dashboard after successful login
- JWT-based authentication for API endpoints
- Session-based authentication for web pages
- Logout functionality
- URL-based access control

## Project Structure

```
auth-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/authapp/
│   │   │       ├── AuthAppApplication.java
│   │   │       ├── config/
│   │   │       │   ├── SecurityConfig.java
│   │   │       │   └── JwtAuthenticationFilter.java
│   │   │       ├── controller/
│   │   │       │   ├── WebAuthController.java
│   │   │       │   └── ApiAuthController.java
│   │   │       ├── dto/
│   │   │       │   ├── LoginRequest.java
│   │   │       │   └── JwtResponse.java
│   │   │       ├── model/
│   │   │       │   └── User.java
│   │   │       ├── repository/
│   │   │       │   └── UserRepository.java
│   │   │       ├── service/
│   │   │       │   └── UserService.java
│   │   │       └── util/
│   │   │           └── JwtUtil.java
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
3. Update the database credentials in `application.properties` if needed (default: root user with 'root' password)

## Running the Application

### Using Maven (Recommended)
1. Navigate to the project directory: `cd auth-app`
2. Run the application: `mvn spring-boot:run`
3. Open your browser and go to `http://localhost:8080`

### Using Gradle
1. Navigate to the project directory: `cd auth-app`
2. Run the application: `./gradlew bootRun` (or `gradlew.bat bootRun` on Windows)
3. Open your browser and go to `http://localhost:8080`

## API Endpoints

- `POST /api/auth/register` - Register a new user
- `POST /api/auth/login` - Authenticate user and return JWT token
- Protected endpoints require `Authorization: Bearer <token>` header

## How to Use

### Web Interface
1. Go to the registration page (`/register`) to create a new account
2. Fill in the username, email, and password fields
3. After successful registration, go to the login page (`/login`)
4. Enter your credentials to access the dashboard
5. Use the logout button to end your session

### API Interface
1. Register a user via `POST /api/auth/register`
2. Login via `POST /api/auth/login` to get a JWT token
3. Include the token in the `Authorization` header for protected endpoints

## URL Permissions

- Public: `/api/auth/**`, `/register`, `/login`, static resources
- Authenticated: `/dashboard` and any other protected endpoints

## Technical Details

- Spring Security for authentication and authorization
- JWT tokens for stateless API authentication
- BCrypt for password hashing
- MySQL database with JPA/Hibernate for persistence
- Session-based authentication for web pages
- Thymeleaf templating engine for views
- Bootstrap for responsive UI
- Spring Boot auto-configuration
- User input validation with annotations