# SkillScope

Know your skills. Take the next step.

SkillScope is an interview platform scaffold with a React frontend and a Spring Boot backend backed by PostgreSQL, Flyway, and Spring Data JDBC.

## Stack

- Frontend: React, TypeScript, Vite
- Backend: Java 25, Spring Boot 4, Spring Data JDBC, Flyway
- Database: PostgreSQL 16
- Local orchestration: Docker Compose

## Project Layout

```text
backend/   Spring Boot API, Flyway migrations, Spring Data JDBC entities and repositories
frontend/  React/Vite application
```

## Quick Start With Docker

```bash
docker compose up --build
```

Services:

- Frontend: http://localhost:3000
- Backend: http://localhost:8080
- Backend health: http://localhost:8080/api/health
- PostgreSQL: localhost:5432, database `skillscope`, user `skillscope`, password `skillscope`

## Local Development

Start PostgreSQL:

```bash
docker compose up -d postgres
```

Run backend:

```bash
cd backend
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

Run frontend:

```bash
cd frontend
npm install
npm run dev
```

Frontend dev server runs on http://localhost:5173 and proxies `/api` to the backend.

## Checks

```bash
cd backend && mvn test
cd frontend && npm run build
```
