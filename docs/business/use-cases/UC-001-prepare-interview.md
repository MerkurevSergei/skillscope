# UC-001 Prepare Interview

Status: draft

## Goal

Reviewer подготавливает интервью для кандидата и задает список вопросов.

## Primary Actor

Reviewer

## Preconditions

- Candidate существует в системе.

## Main Flow

1. Reviewer выбирает candidate.
2. Reviewer создает interview с title, status и optional scheduled time.
3. Reviewer добавляет questions.
4. System сохраняет interview и questions.
5. System показывает interview с вопросами в заданном порядке.

## Alternative Flows

### No Questions Yet

Interview может существовать без questions, если reviewer еще не закончил подготовку.

## Postconditions

- Interview связан с candidate.
- Questions связаны с interview.
- Questions имеют стабильный порядок.

## Related Requirements

- [BR-002 Candidate Profile](../requirements/BR-002-candidate-profile.md)
- [BR-003 Interview Structure](../requirements/BR-003-interview-structure.md)

## Open Questions

- Должен ли status автоматически меняться после scheduled time?
- Нужен ли шаблон вопросов?
