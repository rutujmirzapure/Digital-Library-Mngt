# Digital-Library-Mngt

A Spring Boot application for managing book records in a library, providing CRUD operations and search functionality.

## Features
- Add new books with validation
- View all books in the catalog
- Search books by ID or title
- Update book details
- Delete books
- Maintain availability status
- H2 database integration
- REST API endpoints
- Comprehensive error handling

## Technologies
- Java 17
- Spring Boot 3.2.x
- Spring Data JPA
- H2 Database
- Lombok
- Validation API
- Maven/Gradle

## Prerequisites
- JDK 17
- Maven 3.8+ or Gradle 8.x
- Internet connection (for dependencies)

## Setup Instructions

### 1. Clone the repository
```bash
git clone https://github.com/yourusername/library-management-system.git
cd library-management-system
2. Build the application
Maven:
bash
Copy
mvn clean install
Gradle:
bash
Copy
./gradlew build
3. Run the application
bash
Copy
mvn spring-boot:run
# OR
./gradlew bootRun
API Documentation
Base URL: http://localhost:8080/api/books
Endpoint	Method	Description	Sample Request
/	POST	Add new book	JSON
/	GET	Get all books	-
/search	GET	Search books	?term=history
/{id}	PUT	Update book	JSON
/{id}	DELETE	Delete book	-
Sample Requests:

Add Book
json
Copy
{
  "id": "LIB-001",
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "genre": "Classic",
  "availability": "AVAILABLE"
}
Update Book
json
Copy
{
  "title": "The Great Gatsby (Revised Edition)",
  "author": "F. Scott Fitzgerald",
  "genre": "Literature",
  "availability": "CHECKED_OUT"
}
Database Access
H2 Console URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:librarydb

Username: sa

Password: (leave empty)

Testing the API
Using Swagger UI: http://localhost:8080/swagger-ui.html

Using cURL:

bash
Copy
# Get all books
curl http://localhost:8080/api/books

# Search books
curl http://localhost:8080/api/books/search?term=gatsby
Deployment
Create a JAR file:

bash
Copy
mvn clean package
# OR
./gradlew bootJar
Run the JAR:

bash
Copy
java -jar target/library-system-0.0.1-SNAPSHOT.jar
Deployed example: Live Demo

Project Structure
Copy
src/main/java
├── com.example.library
│   ├── controller      # REST API endpoints
│   ├── model           # Entity classes
│   ├── repository      # Database repositories
│   ├── service         # Business logic
│   └── exception       # Error handling
Reflection
Challenges Faced
Ensuring unique book ID validation

Implementing case-insensitive search

Handling concurrent modification of records

Validating enum values in requests

Maintaining data consistency during updates

Future Improvements
Add pagination for book listings

Implement JWT authentication

Add book lending history tracking

Integrate Redis for caching

Add monitoring with Spring Boot Actuator

Implement proper audit logging

Add unit and integration tests

Create a React frontend interface

License
MIT License - see LICENSE for details
