package ru.skillscope.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import ru.skillscope.domain.Candidate;

public interface CandidateRepository extends CrudRepository<Candidate, UUID> {
}
