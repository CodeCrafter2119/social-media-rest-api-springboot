# Social Media REST API

A robust and secure RESTful API for a social media platform, enabling user management and post interactions. Built with Java, Spring Boot, and modern backend technologies, this API supports CRUD operations for users and their posts, complete with authentication, validation, and Docker integration.

---

## ✨ Features

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

## 🛠️ Tech Stack

- **Backend**: Java 17, Spring Boot 3.x, Spring Security, Hibernate/JPA
- **Database**: MySQL
- **Tools**: Docker, Maven, Postman (for API testing)
- **Libraries**: Lombok, Spring Validation, Spring Data JPA

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- MySQL 8.x
- Docker (optional)
- Maven

### Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/social-media-rest-api.git
   cd social-media-rest-api
