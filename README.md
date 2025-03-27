Digital Library Management System

A Spring Boot application for managing book records in a library, providing CRUD operations and search functionality.

📌 Features

✅ Add new books with validation

📚 View all books in the catalog

🔍 Search books by ID or title

✏️ Update book details

❌ Delete books

📖 Maintain availability status

🛢️ H2 database integration

🌐 REST API endpoints

⚠️ Comprehensive error handling

🛠️ Technologies Used

Java 17

Spring Boot 3.2.x

Spring Data JPA

H2 Database

Lombok

Validation API

Maven/Gradle

⚡ Prerequisites

☕ JDK 17

📦 Maven 3.8+ or Gradle 8.x

🌐 Internet connection (for dependencies)

🚀 Setup Instructions

1️⃣ Clone the Repository

git clone https://github.com/yourusername/library-management-system.git
cd library-management-system

2️⃣ Build the Application

Using Maven:

mvn clean install

Using Gradle:

./gradlew build

3️⃣ Run the Application

mvn spring-boot:run
# OR
./gradlew bootRun

📖 API Documentation

🔗 Base URL: http://localhost:8080/api/books

Endpoint

Method

Description

Sample Request

/

POST

Add new book

JSON

/

GET

Get all books

-

/search

GET

Search books

?term=history

/{id}

PUT

Update book

JSON

/{id}

DELETE

Delete book

-

📌 Sample Requests

➕ Add a Book

{
  "id": "LIB-001",
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "genre": "Classic",
  "availability": "AVAILABLE"
}

🔄 Update a Book

{
  "title": "The Great Gatsby (Revised Edition)",
  "author": "F. Scott Fitzgerald",
  "genre": "Literature",
  "availability": "CHECKED_OUT"
}

🛢️ Database Access

H2 Console URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:librarydb

Username: sa

Password: (leave empty)

🔬 Testing the API

📝 Using Swagger UI

http://localhost:8080/swagger-ui.html

💻 Using cURL

# Get all books
curl http://localhost:8080/api/books

# Search books
curl http://localhost:8080/api/books/search?term=gatsby

🚀 Deployment

📦 Create a JAR File

mvn clean package
# OR
./gradlew bootJar

▶️ Run the JAR

java -jar target/library-system-0.0.1-SNAPSHOT.jar

🌍 Deployed Example: Live Demo

📂 Project Structure

src/main/java
├── com.example.library
│   ├── controller      # REST API endpoints
│   ├── model           # Entity classes
│   ├── repository      # Database repositories
│   ├── service         # Business logic
│   └── exception       # Error handling

🤔 Reflection

🔥 Challenges Faced

Ensuring unique book ID validation

Implementing case-insensitive search

Handling concurrent modification of records

Validating enum values in requests

Maintaining data consistency during updates

🚀 Future Improvements

📜 Add pagination for book listings

🔐 Implement JWT authentication

📖 Add book lending history tracking

⚡ Integrate Redis caching

📊 Add monitoring with Spring Boot Actuator

📝 Implement proper audit logging

✅ Add unit & integration tests

🎨 Create a React frontend interface

📜 License

MIT License - See LICENSE for details.
