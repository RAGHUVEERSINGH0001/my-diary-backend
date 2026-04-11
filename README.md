# 📝 NoteSphere - Secure Notes Management API

A production-ready backend project built using Spring Boot that allows users to securely manage personal notes with authentication, pagination, and API documentation.

---

## 🌟 Why this project?

This project demonstrates real-world backend development skills:

* Secure authentication using JWT
* Clean REST API design
* Scalable architecture using Spring Boot
* Database integration with MongoDB
* Pagination for performance optimization

---

## 🚀 Features

✅ User Registration & Login
✅ JWT-based Authentication & Authorization
✅ Create, Read, Update, Delete Notes
✅ Pagination & Sorting Support
✅ Global Exception Handling
✅ Swagger API Documentation
✅ Clean layered architecture

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* MongoDB
* Maven
* Swagger (OpenAPI)

---

## 📂 Project Architecture

Controller → Handles HTTP Requests
Service → Business Logic
Repository → Database Operations
Model → Data Representation
Security → Authentication & Authorization

---

## ⚙️ Getting Started

### 🔧 Prerequisites

* Java 17+
* Maven
* MongoDB (Local or Atlas)

---

### 📥 Installation

```bash
git clone https://github.com/RAGHUVEERSINGH0001/notesphere.git
cd notesphere
```


---

### ▶️ Run the Project

```bash
./mvnw spring-boot:run
```

---

## 🔐 Authentication Flow

1. Register a user
2. Login to receive JWT Token
3. Use token in headers:

```
Authorization: Bearer <token>
```

---

## 📘 API Documentation

Access Swagger UI:

👉 http://localhost:8080/swagger-ui/index.html

---

## 📌 API Endpoints

### 🔐 Auth APIs

| Method | Endpoint           | Description   |
| ------ | ------------------ | ------------- |
| POST   | /api/auth/register | Register user |
| POST   | /api/auth/login    | Login user    |

### 📝 Notes APIs

| Method | Endpoint        | Description   |
| ------ | --------------- | ------------- |
| GET    | /api/notes      | Get all notes |
| POST   | /api/notes      | Create note   |
| PUT    | /api/notes/{id} | Update note   |
| DELETE | /api/notes/{id} | Delete note   |

---

## 📊 Key Highlights

* 🔐 Stateless Authentication using JWT
* ⚡ Optimized APIs with Pagination
* 🧱 Layered Architecture (Best Practice)
* 📚 Self-documented APIs using Swagger

---



## 🧪 Testing

Used Swagger  to test all endpoints.

---<img width="1080" height="675" alt="Screenshot 2026-04-11 at 1 38 29 PM" src="https://github.com/user-attachments/assets/36acee19-6f9f-4648-936b-c38ad3c2427a" />


## 📸 Screenshots

Used Postman to test all the endpoints
<img width="1192" height="725" alt="Screenshot 2026-04-11 at 1 39 40 PM" src="https://github.com/user-attachments/assets/037dd5af-2e64-4e7b-bd5e-b47fc9197e74" />


---

## 🤝 Contribution

Feel free to fork and contribute.

---

## 👨‍💻 Author

Raghuveer Singh
GitHub: https://github.com/RAGHUVEEERSINGH0001

---

## ⭐ Show Your Support

If you like this project, give it a ⭐ on GitHub!
