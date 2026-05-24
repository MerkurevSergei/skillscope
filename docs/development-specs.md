# Development Specs

Этот документ описывает технические договоренности проекта. Он должен отвечать на вопрос: как именно реализовывать новые изменения.

## Stack

- Java 25
- Spring Boot 4
- Spring Data JDBC
- PostgreSQL 16
- Flyway
- React 18
- TypeScript
- Vite
- Docker Compose

## Repository Layout

- `backend/` — Spring Boot API, доменная модель, repositories, миграции БД.
- `frontend/` — React/Vite приложение.
- `docs/` — бизнес-требования, технические спецификации и схема БД.
- `docker-compose.yml` — локальная инфраструктура.

## Backend Conventions

- Persistence layer использует Spring Data JDBC, не JPA.
- Доменные классы используют `org.springframework.data.relational.core.mapping.Table` и `Column`.
- Репозитории наследуются от `CrudRepository`.
- Связи между таблицами в Java-модели выражаются через foreign key поля (`candidateId`, `interviewId`, `reviewerId`), а не через lazy entity references.
- Database defaults вроде `created_at default now()` помечаются как read-only поля через `@ReadOnlyProperty`.
- Схема БД изменяется только через Flyway migrations в `backend/src/main/resources/db/migration`.
- `application-dev.yml` содержит dev-настройки инфраструктуры, но не должен включать JPA/Hibernate настройки.

## Security Conventions

- `/api/health` публичный.
- Остальные endpoint требуют authentication, пока не принято другое явное решение.
- Полная модель authentication/authorization пока не определена.

## API Conventions

- Все backend API должны жить под `/api`.
- Health endpoint: `GET /api/health`.
- JSON поля использовать в `camelCase`.
- Для новых endpoint сначала фиксировать ожидаемый контракт в этом документе или отдельной development spec секции.

## Frontend Conventions

- Frontend обращается к backend через `/api`.
- Dev server Vite проксирует `/api` на backend.
- UI должен быть рабочим приложением, без отдельной landing page, если задача просит инструмент или интерфейс.

## Checks

Перед завершением backend изменений:

```bash
cd backend
mvn clean test
```

Перед завершением frontend изменений:

```bash
cd frontend
npm run build
```

## Definition Of Done

- Код компилируется.
- Релевантные тесты проходят.
- Если менялась схема БД, обновлена Flyway migration или добавлена новая.
- Если менялось поведение, обновлены docs.
- Если добавлен API, описан контракт и ожидаемые ошибки.

## Open Questions

- Нужен ли отдельный слой service для всех доменных операций?
- Какая стратегия ошибок будет стандартной: Problem Details или собственный формат?
- Нужна ли OpenAPI-спецификация?
- Нужно ли вводить ADR для архитектурных решений?

