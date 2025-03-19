# Social Media REST API

A robust and secure RESTful API for a social media platform, enabling user management and post interactions. Built with Java, Spring Boot, and modern backend technologies, this API supports CRUD operations for users and their posts, complete with authentication, validation, and Docker integration.

---

## Features

- **User Management**:
  - Create, retrieve, update, and delete users.
  - Secure password storage with Spring Security.
  - Input validation for user data (e.g., email format, password rules).

- **Post Management**:
  - Create, retrieve, and delete posts for specific users.
  - Fetch all posts associated with a user.

- **Security**:
  - Role-based access control with Spring Security.
  - JWT authentication (optional; enable in configurations).

- **Technical Highlights**:
  - Database persistence with **Hibernate/JPA** and **MySQL**.
  - Docker containerization for seamless deployment.
  - Custom error handling with structured JSON responses.
  - API validation for robust input sanitization.

---

##  Tech Stack

- **Backend**: Java 23, Spring Boot 3.4.3, Spring Security, Hibernate/JPA
- **Database**: MySQL
- **Tools**: Docker, Maven, Talent API tester (for API testing)
- **Libraries**: Spring Validation, Spring Data JPA

---

### Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/username/social-media-rest-api.git
   cd social-media-rest-api



### Configure Database:

Create a MySQL database named social_media_db.

Update application.properties with credentials:

properties::

spring.datasource.url=jdbc:mysql://localhost:3307/social_media_db
spring.datasource.username=username
spring.datasource.password=123

### Build & Run:
mvn clean install
mvn spring-boot:run
The API will start at http://localhost:8080.

### 📚 API Documentation
Users Endpoints
Endpoint	Method	Description
/jpa/users	GET	Retrieve all users
/jpa/users	POST	Create a new user
/jpa/users/{id}	GET	Get user by ID
/jpa/users/{id}	DELETE	Delete a user by ID
Posts Endpoints
Endpoint	Method	Description
/jpa/users/{userId}/posts	GET	Get all posts by a user
/jpa/users/{userId}/posts	POST	Create a new post for a user
/jpa/users/{userId}/posts/{postId}	DELETE	Delete a specific post


### Docker Support
Build the Docker Image:

docker build -t social-media-api .

Run the Container:

docker run -p 3307:3306 social-media-api

