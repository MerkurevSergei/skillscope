create extension if not exists pgcrypto;

create table app_user (
    id uuid primary key default gen_random_uuid(),
    email varchar(255) not null unique,
    display_name varchar(160) not null,
    role varchar(40) not null,
    created_at timestamptz not null default now()
);

create table candidate (
    id uuid primary key default gen_random_uuid(),
    full_name varchar(180) not null,
    email varchar(255),
    target_role varchar(160),
    created_at timestamptz not null default now()
);

create table interview (
    id uuid primary key default gen_random_uuid(),
    candidate_id uuid not null references candidate(id),
    title varchar(220) not null,
    status varchar(40) not null,
    scheduled_at timestamptz,
    created_at timestamptz not null default now()
);

create table interview_question (
    id uuid primary key default gen_random_uuid(),
    interview_id uuid not null references interview(id) on delete cascade,
    prompt text not null,
    expected_level varchar(40),
    sort_order integer not null default 0
);

create table interview_feedback (
    id uuid primary key default gen_random_uuid(),
    interview_id uuid not null references interview(id) on delete cascade,
    reviewer_id uuid references app_user(id),
    score integer check (score between 1 and 5),
    summary text,
    created_at timestamptz not null default now()
);

create index idx_interview_candidate_id on interview(candidate_id);
create index idx_interview_question_interview_id on interview_question(interview_id);
create index idx_interview_feedback_interview_id on interview_feedback(interview_id);
