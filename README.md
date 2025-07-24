# Intelligent Investment Allocation API

A production-grade Java backend API that simulates intelligent portfolio allocation — similar to how robo-advisors or institutional platforms (e.g., BlackRock’s Aladdin) allocate capital based on user profiles and investment strategies.

This project is designed for:
- Real-world portfolio management simulation
- Learning Spring Boot, RESTful API, PostgreSQL, and Docker
- FinTech and investment-related backends
- Open source contributions and experimentation

---

## Tech Stack

- **Java 21**
- **Spring Boot 3.5.3**
- **PostgreSQL**
- **Maven**
- **JPA/Hibernate**
- **REST API**
- **OpenAPI (Swagger)**
- **Docker + Docker Compose**

---

## Features

### 1. User Investment Profile Input
Capture key attributes like:
```json
{
  "age": 35,
  "capital": 10000,
  "riskTolerance": "medium",
  "investmentHorizon": 5
}
```

## Smart Allocation Engine

### Simulate capital allocation based on predefined rules:

- **Strategy Profiles: Conservative, Balanced, Aggressive**

- **Example output:**
```json
{
  "userId": 1,
  "percentageAllocation": {
    "stocks": 50,
    "bonds": 30,
    "crypto": 10,
    "cash": 10
  },
  "dollarAllocation": {
    "stocks": 5000,
    "bonds": 3000,
    "crypto": 1000,
    "cash": 1000
  }
}
```

## Persistent Plans (via PostgreSQL)
- **User profile & plan saved to database**

- **Easily extendable to track historical strategies**

## OpenAPI (Swagger)
- **Visit: http://localhost:8080/swagger-ui.html**

- **Full documentation of all endpoints**


## Run Locally with Docker
### Prerequisites
- **Docker & Docker Compose**
- **Java 21 (only if you want to run without Docker)**

# 1. Clone the repo
```bash
git clone https://github.com/masoudm93/Intelligent-Investment-API.git
cd intelligentinvestmentapi

# 2. Package the app
./mvnw clean package

# 3. Run via Docker Compose
docker-compose up --build
```
### Once running, access:

- **Swagger: http://localhost:8080/swagger-ui.html**
- **PostgreSQL: available internally as postgres:5432**

## Contributing
We welcome contributions from developers, financial engineers, and tech enthusiasts!

### Steps to Contribute
- **Fork this repository**

- **Create a new feature branch: git checkout -b feature/my-feature**

- **Commit your changes: git commit -am "Add my feature"**

- **Push the branch: git push origin feature/my-feature**

- **Open a Pull Request and describe your changes**
