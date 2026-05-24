# BR-001 Question Card Library

Status: draft

## Business Need

- Система должна хранить карточки вопросов с классификацией.
- Карточки используются для формирования профилей интервью, ручного подбора вопросов и предложения вопросов по заданной классификации во время интервью.
- Карточка содержит основной вопрос, уточняющие вопросы и критерии оценки глубины ответа кандидата.

## Scope

Question card содержит:

- title
- prompt
- status
- subject area
- category / subtopic
- topic
- question type
- question depth
- competency
- interviewer hints
- follow-up questions
- answer evaluation criteria
- tags / aliases
- creation timestamp

## Principles

- Question card описывает вопрос, а не конкретное интервью.
- Question card описывает область знания, а не профессию, роль или профиль интервью.
- Профиль интервью должен собираться из классификационных полей карточки, без поля `applicable profiles` в самой карточке.
- Основная классификация хранится в `subject area`, `category / subtopic`, `topic`, `question type` и `question depth`.
- `tags / aliases` используются для поиска и синонимов, но не для основной классификации.
- `question depth` описывает глубину карточки, а `answer evaluation criteria` описывают глубину ответа кандидата.
- Active question card не редактируется по содержанию; для изменения создается новая question card.
- Версионирование question card не используется.

## Classification

### Subject Area

`subject area` — крупная область знания.

Примеры допустимого масштаба:

- `Java`
- `Spring`
- `JavaScript`
- `React`
- `Object-Oriented Programming`
- `SQL`
- `Databases`
- `BPMN`
- `Business Analysis`
- `System Design`
- `Testing`

Примеры значений, которые слишком мелкие для `subject area`:

- `Java Core`
- `String Pool`
- `Java Collections`
- `Spring Transactions`
- `React Hooks`
- `BPMN Gateways`
- `SQL Indexes`

Такие значения должны храниться в `category / subtopic`, `topic` или `tags / aliases`.

Справочник `subject area` не должен содержать конкурирующие значения, где одно значение является уточнением другого. Например, не нужно одновременно заводить `Java` и `Java Core`, если `Java Core` можно выразить через `Java` + `category / subtopic` или `topic`.

### Category / Subtopic

`category / subtopic` — часть subject area. Поле необязательное.

Примеры:

- `Java` -> `Memory`
- `Java` -> `Collections`
- `Java` -> `Concurrency`
- `Spring` -> `Data Access`
- `Spring` -> `Security`
- `Object-Oriented Programming` -> `Design Principles`
- `BPMN` -> `Flow Control`
- `React` -> `State Management`

### Topic

`topic` — конкретная тема вопроса.

Примеры:

- `String Pool`
- `HashMap internals`
- `Transaction propagation`
- `SOLID`
- `BPMN gateways`
- `State update batching`
- `Use case boundaries`

### Question Type

`question type` — формат проверки. У карточки может быть несколько значений.

Допустимые значения на первом этапе:

- `theory`
- `code-reading`
- `practical-task`
- `case`
- `architecture`
- `debugging`
- `design-review`

### Question Depth

`question depth` — глубина проверки в рамках карточки. Поле не является уровнем кандидата и не запрещает задавать foundation-вопрос кандидату с большим опытом.

Допустимые значения на первом этапе:

- `foundation`
- `working`
- `advanced`
- `expert`

### Competency

`competency` — способность, которую проверяет вопрос. У карточки может быть несколько значений.

Допустимые значения на первом этапе:

- `knowledge`
- `reasoning`
- `hands-on`
- `debugging`
- `design`
- `modeling`
- `communication`
- `trade-offs`

### Tags / Aliases

`tags / aliases` — дополнительные поисковые ключи, синонимы и технические термины.

Примеры:

- `jvm`
- `intern`
- `equals`
- `==`
- `@Transactional`
- `rollback`
- `exclusive-gateway`
- `useState`

`tags / aliases` не должны использоваться как profile tags, например `backend`, `frontend`, `system-analysis`.

## Answer Support

Question card содержит внутренние материалы для interviewer/admin:

- `interviewer hints`
- `follow-up questions`
- `answer evaluation criteria`

`interviewer hints` могут содержать:

- цель вопроса;
- детали, которые нужно проверить;
- типичные ошибки кандидатов;
- red flags.

`follow-up questions` содержат уточняющие вопросы, которые можно задать после основного вопроса.

`answer evaluation criteria` описывают наблюдаемые признаки ответа кандидата. Рекомендуемый формат:

- базовый ответ;
- хороший ответ;
- сильный ответ.

Каждый критерий должен описывать, что кандидат сказал, объяснил, применил или заметил.

Пример для Java String Pool:

- Базовый ответ: кандидат говорит, что `"a" != new String("a")`, но не объясняет причину полностью.
- Хороший ответ: кандидат объясняет String Pool и разные object references.
- Сильный ответ: кандидат объясняет, как получить равенство при сравнении через `==`, и упоминает `intern()`.

Пример follow-up questions для Java String Pool:

- Почему `"a" == new String("a")` возвращает `false`?
- Как изменить пример, чтобы сравнение через `==` вернуло `true`?
- Что делает `intern()`?
- Чем `==` отличается от `equals()` при сравнении строк?

## Status Lifecycle

Question card может иметь один из статусов:

- `draft`
- `active`
- `archived`

Draft card:

- имеет title;
- может не иметь полной классификации;
- может редактироваться;
- не попадает в подборку вопросов по умолчанию.

Active card:

- имеет title, prompt, subject area, topic, question type, question depth и хотя бы один answer evaluation criterion;
- не редактируется по содержанию;
- может быть переведена в `archived`.

Archived card:

- не используется для новых интервью по умолчанию;
- остается доступной для истории и анализа.

## Business Rules

- Title обязателен для любой question card.
- Status обязателен для любой question card.
- Prompt обязателен для перевода question card в `active`.
- Subject area обязателен для перевода question card в `active`.
- Topic обязателен для перевода question card в `active`.
- Question type обязателен для перевода question card в `active`.
- Question depth обязателен для перевода question card в `active`.
- Хотя бы один answer evaluation criterion обязателен для перевода question card в `active`.
- Category / subtopic необязателен.
- Competency необязателен.
- У question card должен быть один subject area.
- У question card может быть не более одного category / subtopic.
- У question card должен быть один topic.
- У question card может быть несколько question types.
- У question card должен быть один question depth.
- У question card может быть несколько competencies.
- У question card может быть ноль или больше follow-up questions.
- У question card может быть один или больше answer evaluation criteria.
- У question card может быть ноль или больше tags / aliases.
- Subject area не должен быть job profile.
- Subject area не должен дублировать topic или category / subtopic.
- Question card не должна содержать applicable profiles.
- Question depth не должен использоваться как уровень кандидата.
- Answer evaluation criteria должны описывать глубину ответа кандидата, а не только эталонный правильный ответ.
- Follow-up questions не должны содержать готовый ответ.
- Tags / aliases не должны использоваться как основной механизм сборки профилей.
- Система должна предлагать существующие значения subject area, category / subtopic и topic при создании карточки.
- Interviewer hints, follow-up questions и answer evaluation criteria не предназначены для candidate-facing сценариев.
- Детальные правила видимости откладываются до финализации ролевой модели.
- Active question card нельзя редактировать по содержанию.
- Для изменения active question card создается новая question card.
- Версионирование question card не требуется.

## Examples

| Card | Subject area | Category / subtopic | Topic | Question type | Question depth | Competency | Tags / aliases |
|---|---|---|---|---|---|---|---|
| Java String Pool | `Java` | `Memory` | `String Pool` | `theory`, `code-reading` | `foundation` | `knowledge`, `reasoning` | `jvm`, `intern`, `equals`, `==` |
| SOLID | `Object-Oriented Programming` | `Design Principles` | `SOLID` | `theory`, `case`, `design-review` | `working` | `design`, `reasoning`, `trade-offs` | `oop`, `maintainability`, `design-principles` |
| Spring Transactions | `Spring` | `Data Access` | `Transaction propagation` | `theory`, `case`, `debugging` | `advanced` | `knowledge`, `reasoning`, `debugging` | `@Transactional`, `rollback`, `propagation` |
| BPMN Gateways | `BPMN` | `Flow Control` | `Gateways` | `case`, `practical-task` | `foundation` | `modeling`, `reasoning`, `communication` | `exclusive-gateway`, `parallel-gateway`, `inclusive-gateway` |
| React State Updates | `React` | `State Management` | `State update batching` | `theory`, `code-reading`, `debugging` | `advanced` | `knowledge`, `reasoning`, `debugging` | `useState`, `render`, `batching`, `concurrent-rendering` |

## Acceptance Criteria

- Можно создать draft question card с title.
- Можно сохранить draft question card без prompt и без полной классификации.
- Нельзя перевести question card в `active` без title, prompt, subject area, topic, question type, question depth и хотя бы одного answer evaluation criterion.
- Можно назначить question card один subject area.
- Можно назначить question card optional category / subtopic.
- Можно назначить question card один topic.
- Можно назначить question card несколько question types.
- Можно назначить question card один question depth.
- Можно назначить question card несколько competencies.
- Можно добавить несколько follow-up questions к одной question card.
- Можно хранить follow-up questions отдельно от interviewer hints и answer evaluation criteria.
- Можно назначить question card несколько tags / aliases.
- Можно искать и фильтровать question cards по subject area.
- Можно искать и фильтровать question cards по category / subtopic.
- Можно искать и фильтровать question cards по topic.
- Можно искать и фильтровать question cards по question type.
- Можно искать и фильтровать question cards по question depth.
- Можно искать question cards по tags / aliases.
- Можно хранить interviewer hints отдельно от prompt.
- Можно хранить несколько answer evaluation criteria для одной question card.
- Candidate-facing сценарии не должны показывать interviewer hints, follow-up questions и answer evaluation criteria.
- Active question card нельзя редактировать по содержанию.
- Active question card можно перевести в `archived`.
- Archived question card не попадает в подборку новых вопросов по умолчанию.
- Для изменения active question card создается новая question card.
- Профиль интервью можно будет собрать без поля applicable profiles, используя subject area, category / subtopic, topic, question type и question depth.

## Out Of Scope

- Ролевая модель и точные права доступа.
- Конструктор профилей интервью.
- Автоматическая рекомендация вопросов.
- Версионирование question cards.
- Оценка кандидата как отдельный результат интервью.

## Open Questions

- Нужен ли category / subtopic как обязательное поле после стабилизации справочников?
- Должны ли subject area, category / subtopic и topic быть полностью управляемыми справочниками или можно разрешить свободный ввод с последующей нормализацией?
- Нужно ли хранить числовой вес или score для answer evaluation criteria?
- Нужно ли поддерживать detection похожих question cards перед созданием новой active card?
