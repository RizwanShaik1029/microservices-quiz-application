# Microservices Quiz Application

A Spring Boot–based microservices application for managing quizzes and questions using modern cloud-native architecture.

---

## 🚀 Project Overview

This project is a microservices-based quiz management system built using Spring Boot and Spring Cloud.

It provides:
- Quiz management
- Question management
- Centralized API Gateway
- Service Discovery with Eureka

---

## 🏗️ System Architecture

### Services

| Service Name      | Description                  | Port |
|-------------------|------------------------------|------|
| Eureka Server     | Service Registry             | 8761 |
| API Gateway       | Request Routing              | 8080 |
| Quiz Service      | Quiz Management              | 8081 |
| Question Service  | Question Management          | 8082 |

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Cloud (Eureka, Gateway)
- Spring Data JPA
- MySQL / H2
- Maven

---

## 📂 Project Structure

microservices-quiz-application/
│
├── eureka-server/
├── api-gateway/
├── quiz-service/
├── question-service/
└── README.md


---

## ▶️ How to Run the Project

### 1️⃣ Clone Repository

```bash
git clone https://github.com/RizwanShaik1029/microservices-quiz-application.git
cd microservices-quiz-application


### 2️⃣ Start Eureka Server
cd eureka-server
mvn spring-boot:run

Open:
http://localhost:8761


### 3️⃣ Start API Gateway
cd api-gateway
mvn spring-boot:run

### 4️⃣ Start Other Services
#### Quiz Service
cd quiz-service
mvn spring-boot:run

#### Question Service
cd question-service
mvn spring-boot:run

## 🔌 API Access (Via Gateway)
### Example URLs:

http://localhost:8080/quiz/all
http://localhost:8080/questions/all

---

## ✅ Features
Microservices Architecture

Service Discovery (Eureka)

API Gateway Routing

RESTful APIs

Scalable Design
