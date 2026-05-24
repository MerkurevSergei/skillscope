# Business Documentation

Status: draft

Этот раздел хранит бизнес-контекст SkillScope в виде небольших связанных документов.

Главная идея: каждое требование, use case или user story живет в отдельном файле с устойчивым ID. Индекс ниже помогает быстро понять, что существует, что утверждено и с чем связана разработка.

## Navigation

- [overview.md](overview.md) — продукт, роли, основные понятия и открытые вопросы.
- [requirements/](requirements/) — бизнес-требования от бизнеса.
- [use-cases/](use-cases/) — сценарии взаимодействия акторов с системой.
- [user-stories/](user-stories/) — user stories для планирования разработки.
- [templates/](templates/) — шаблоны новых документов.

## Statuses

- `draft` — черновик, можно менять свободно.
- `review` — ожидает подтверждения.
- `approved` — согласовано как источник истины.
- `implemented` — реализовано в коде.
- `deprecated` — больше не актуально.

## Requirements Index

| ID | Title | Status | File | Related |
|---|---|---|---|---|
| BR-001 | Question card library | draft | [BR-001-question-card-library.md](requirements/BR-001-question-card-library.md) | Future DB: `question_card` |
| BR-002 | Candidate profile | draft | [BR-002-candidate-profile.md](requirements/BR-002-candidate-profile.md) | DB: `candidate` |
| BR-003 | Interview structure | draft | [BR-003-interview-structure.md](requirements/BR-003-interview-structure.md) | DB: `interview`, `interview_question` |
| BR-004 | Interview feedback | draft | [BR-004-interview-feedback.md](requirements/BR-004-interview-feedback.md) | DB: `interview_feedback`, `app_user` |

## Use Cases Index

| ID | Title | Status | File | Related |
|---|---|---|---|---|
| UC-001 | Prepare interview | draft | [UC-001-prepare-interview.md](use-cases/UC-001-prepare-interview.md) | BR-002, BR-003 |
| UC-002 | Leave interview feedback | draft | [UC-002-leave-interview-feedback.md](use-cases/UC-002-leave-interview-feedback.md) | BR-004 |

## User Stories Index

| ID | Title | Status | File | Related |
|---|---|---|---|---|
| US-001 | Reviewer sees candidate context | draft | [US-001-reviewer-sees-candidate-context.md](user-stories/US-001-reviewer-sees-candidate-context.md) | BR-002, UC-001 |
| US-002 | Reviewer records feedback | draft | [US-002-reviewer-records-feedback.md](user-stories/US-002-reviewer-records-feedback.md) | BR-004, UC-002 |

## Maintenance Rules

- Новый документ должен получить ID перед началом реализации.
- Один файл должен описывать одну бизнес-идею или один сценарий.
- Если требование меняет схему БД, обновить [../database-schema.md](../database-schema.md).
- Если требование меняет API или техническое поведение, обновить [../development-specs.md](../development-specs.md).
- Пока бизнес явно не подтвердил документ, оставлять `Status: draft`.
