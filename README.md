# CollegeEventPortal

CollegeEventPortal is a full-stack **College Event Management System** developed using **Spring Boot** for the backend and **HTML, CSS, and JavaScript** for the frontend.  
The application implements **JWT-based authentication** and **role-based access control (User/Admin)** along with event management features.  
This project is designed for **academic submission and practical learning**.

---

## Features

### Backend (Spring Boot)
- User registration and login
- Password hashing using `PasswordEncoder`
- JWT-based authentication
- Role-based access control (USER / ADMIN)
- RESTful API design
- CRUD operations for Events
- Database integration using MySQL / MariaDB
- Layered architecture (Controller, Service, Repository)
- Custom security configuration

### Frontend (HTML, CSS, JavaScript)
- Modern interactive UI (single-page application)
- Sign-up and Login functionality
- JWT stored securely in browser storage
- Protected dashboard access
- Add and view events dynamically
- Role-based UI handling (can be extended)

---

## Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT (JSON Web Token)
- Hibernate ORM
- MySQL / MariaDB
- RAG AI

### Frontend
- React
- HTML5
- CSS3
- JavaScript (ES6)
- Fetch API

---

## Project Structure
CollegeEventPortal/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── college/
│       │           └── eventportal/
│       │               ├── controller/
│       │               ├── service/
│       │               ├── repository/
│       │               ├── entity/
│       │               ├── dto/
│       │               └── config/
│       │                   ├── SecurityConfig.java
│       │                   ├── JwtUtil.java
│       │                   └── JwtAuthFilter.java
│       │
│       └── resources/
│           ├── application.properties
│           └── static/
│               └── index.html
│
├── pom.xml
└── README.md


---

## Authentication & Authorization

### 🔐 JWT Authentication
- On successful login, a **JWT token** is generated
- Token contains user identity and role
- Token is sent in `Authorization` header for protected APIs


### 👤 Role-Based Access
- `ROLE_USER` – Can view and add events
- `ROLE_ADMIN` – Can manage all events (extendable)

Access control is enforced using **Spring Security filters**.
--OUTPUT
<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/5346a306-db91-40de-be4c-74eb1dafbb89" />

<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/9ada399f-3ec3-4d84-8c23-32972ceaa57e" />

<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/f8cc39d3-7a03-40ef-b968-afd167a9913c" />

<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/b432c27f-e3d4-4c18-b070-a13ff387abbb" />

<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/57197b82-3fc4-4c03-bd76-84f73e916ee8" />

---



