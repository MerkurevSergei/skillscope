package ru.skillscope.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import ru.skillscope.domain.Interview;

public interface InterviewRepository extends CrudRepository<Interview, UUID> {

    List<Interview> findByCandidateId(UUID candidateId);
}
