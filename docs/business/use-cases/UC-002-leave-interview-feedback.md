# UC-002 Leave Interview Feedback

Status: draft

## Goal

Reviewer оставляет результат оценки после интервью.

## Primary Actor

Reviewer

## Preconditions

- Interview существует в системе.

## Main Flow

1. Reviewer открывает interview.
2. Reviewer указывает score.
3. Reviewer добавляет optional summary.
4. System сохраняет feedback.
5. System показывает feedback в контексте interview.

## Alternative Flows

### Anonymous Or Unassigned Reviewer

Если reviewer еще не связан с системой пользователей, feedback сохраняется без `reviewerId`.

## Postconditions

- Feedback связан с interview.
- Score находится в диапазоне 1..5.

## Related Requirements

- [BR-004 Interview Feedback](../requirements/BR-004-interview-feedback.md)

## Open Questions

- Нужно ли требовать summary при низком score?
- Может ли reviewer редактировать feedback после сохранения?
