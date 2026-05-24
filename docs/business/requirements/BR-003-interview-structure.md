# BR-003 Interview Structure

Status: draft

## Business Need

Система должна хранить интервью кандидата и набор вопросов, чтобы reviewer мог подготовить и провести оценку структурированно.

## Scope

Interview содержит:

- candidate reference
- title
- status
- scheduled time
- creation timestamp

Interview question содержит:

- interview reference
- prompt
- expected level
- sort order

## Business Rules

- Interview всегда принадлежит candidate.
- Title обязателен.
- Status обязателен.
- Scheduled time необязателен.
- Question всегда принадлежит interview.
- Prompt вопроса обязателен.
- Questions должны поддерживать стабильный порядок через `sort_order`.
- Удаление interview удаляет связанные questions на уровне БД.

## Acceptance Criteria

- Можно получить список interview по candidate.
- Можно получить вопросы interview в порядке `sort_order`.
- У interview может быть ноль или больше questions.

## Related

- DB tables: `interview`, `interview_question`
- Related requirement: [BR-001 Question Card Library](BR-001-question-card-library.md)
- Use case: [UC-001 Prepare interview](../use-cases/UC-001-prepare-interview.md)

## Open Questions

- Какие статусы interview допустимы?
- Нужно ли хранить тип interview: screening, technical, final?
- Должен ли interview question хранить snapshot question card на момент добавления в interview?
