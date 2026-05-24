package ru.skillscope.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import ru.skillscope.domain.InterviewQuestion;

public interface InterviewQuestionRepository extends CrudRepository<InterviewQuestion, UUID> {

    List<InterviewQuestion> findByInterviewIdOrderBySortOrderAsc(UUID interviewId);
}
