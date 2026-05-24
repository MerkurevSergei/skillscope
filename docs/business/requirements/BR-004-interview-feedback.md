# BR-004 Interview Feedback

Status: draft

## Business Need

Система должна хранить обратную связь по интервью, чтобы результат оценки был доступен после проведения интервью.

## Scope

Feedback содержит:

- interview reference
- optional reviewer reference
- score
- summary
- creation timestamp

## Business Rules

- Feedback всегда относится к interview.
- Reviewer может быть пустым, пока модель пользователей не финализирована.
- Score может быть от 1 до 5.
- Summary необязателен.
- Удаление interview удаляет связанный feedback на уровне БД.

## Acceptance Criteria

- Можно получить feedback по interview.
- Score вне диапазона 1..5 не допускается.
- Feedback можно сохранить без reviewer.

## Related

- DB tables: `interview_feedback`, `app_user`
- Use case: [UC-002 Leave interview feedback](../use-cases/UC-002-leave-interview-feedback.md)

## Open Questions

- Может ли у одного interview быть несколько feedback от разных reviewers?
- Нужно ли хранить историю изменений feedback?
- Нужно ли разделять score по категориям?
