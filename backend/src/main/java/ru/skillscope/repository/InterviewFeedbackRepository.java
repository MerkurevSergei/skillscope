package ru.skillscope.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import ru.skillscope.domain.InterviewFeedback;

public interface InterviewFeedbackRepository extends CrudRepository<InterviewFeedback, UUID> {

    List<InterviewFeedback> findByInterviewId(UUID interviewId);
}
