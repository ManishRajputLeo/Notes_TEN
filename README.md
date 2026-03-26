# Notes App (Spring Boot + Spring Security)

This is a simple Notes backend application built using Java and Spring Boot. It includes basic CRUD operations for notes and uses Spring Security to protect APIs.

## Features
- Create, read, update, delete notes
- Secured APIs using Spring Security (Basic Authentication)
- Public and protected endpoints
- Simple and clean structure

## Tech Stack
- Java
- Spring Boot
- Spring Security
- Maven

## How to Run
1. Clone the repository
2. Open the project in IntelliJ or Eclipse
3. Run the main application class
4. Server starts on: http://localhost:8080

## Security
- All endpoints are secured by default
- Basic Authentication is enabled
- Default credentials:
  - Username: ****
  - Password: ****

## API Testing
Use Postman to test APIs.

Example:

GET /notes  

Authorization:
- Type: Basic Auth  
- Username: user  
- Password: (check console)

## Public Endpoint (Optional)
Endpoints under `/public/**` are accessible without authentication.
