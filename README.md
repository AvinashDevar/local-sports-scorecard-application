# 🏆 Local Sports Scorecard Application

A Spring Boot REST API application for managing local sports tournaments. This project helps organize tournaments, teams, players, matches, venues, umpires, and scorecards while maintaining match results using PostgreSQL.

---

## 🚀 Features

- Tournament Management (CRUD)
- Team Management (CRUD)
- Player Management (CRUD)
- Match Scheduling
- Scorecard Management
- RESTful APIs
- Exception Handling
- Layered Architecture
- PostgreSQL Database Integration

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA (Hibernate)
- PostgreSQL
- Maven
- REST API
- Lombok
- Postman

---

## 📁 Project Structure

```
LocalSportsScorecardApplication
│── src
│   ├── main
│   │   ├── java
│   │   │   ├── controller
│   │   │   ├── service
│   │   │   ├── repository
│   │   │   ├── entity
│   │   │   ├── dao
│   │   │   ├── exception
│   │   │   └── util
│   │   └── resources
│   │       ├── application.properties
│   │       └── static
│   └── test
│
├── pom.xml
└── README.md
```

---

## ⚙️ Installation

### 1. Clone the Repository

```bash
git clone https://github.com/AvinashDevar/local-sports-scorecard-application.git
```

### 2. Navigate to the Project

```bash
cd local-sports-scorecard-application
```

### 3. Configure Database

Update your `application.properties` file.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/localsportsscorecard
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Build the Project

```bash
mvn clean install
```

### 5. Run the Application

```bash
mvn spring-boot:run
```

The application will start on:

```
http://localhost:8080
```

---

## 📌 API Endpoints

### Tournament

| Method | Endpoint |
|---------|----------|
| POST | `/tournament/save` |
| GET | `/tournament/find/{id}` |
| PUT | `/tournament/update/{id}` |
| DELETE | `/tournament/delete/{id}` |

### Team

| Method | Endpoint |
|---------|----------|
| POST | `/team/save` |
| GET | `/team/find/{id}` |
| PUT | `/team/update/{id}` |
| DELETE | `/team/delete/{id}` |

### Player

| Method | Endpoint |
|---------|----------|
| POST | `/player/save` |
| GET | `/player/find/{id}` |
| PUT | `/player/update/{id}` |
| DELETE | `/player/delete/{id}` |

### Match

| Method | Endpoint |
|---------|----------|
| POST | `/match/save` |
| GET | `/match/find/{id}` |
| PUT | `/match/update/{id}` |
| DELETE | `/match/delete/{id}` |

### Scorecard

| Method | Endpoint |
|---------|----------|
| POST | `/scorecard/save` |
| GET | `/scorecard/find/{id}` |
| PUT | `/scorecard/update/{id}` |
| DELETE | `/scorecard/delete/{id}` |

---

## 🗄️ Database

- PostgreSQL
- Spring Data JPA
- Hibernate ORM

---

## 🧪 Testing

Use **Postman** to test all REST APIs.

---


## 🔮 Future Enhancements

- JWT Authentication
- Role-Based Access Control
- Live Match Scoring
- Points Table
- Player Statistics
- Team Rankings
- Cloud Deployment

---

## 👨‍💻 Author

**Avinash Devar**

- B.Sc. Information Technology
- Java Developer
- Spring Boot | Hibernate | PostgreSQL | REST API

---

## ⭐ Show Your Support

If you found this project helpful, please give it a ⭐ on GitHub.

Happy Coding! 🚀
