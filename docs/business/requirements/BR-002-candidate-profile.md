# BR-002 Candidate Profile

Status: draft

## Business Need

Система должна хранить карточку кандидата, чтобы интервью и обратная связь были привязаны к конкретному человеку.

## Scope

Кандидат содержит:

- full name
- email
- target role
- creation timestamp

## Business Rules

- Full name обязателен.
- Email кандидата необязателен.
- Target role необязателен.
- Candidate является объектом учета, пока не принято отдельное решение о личном доступе кандидата в систему.

## Acceptance Criteria

- Можно однозначно идентифицировать кандидата по `id`.
- Можно связать interview с candidate.
- Можно хранить candidate без email.

## Related

- DB table: `candidate`
- Use case: [UC-001 Prepare interview](../use-cases/UC-001-prepare-interview.md)

## Open Questions

- Должен ли email кандидата быть уникальным?
- Нужны ли дополнительные поля: phone, resume link, location, seniority?
