package ru.skillscope.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import ru.skillscope.domain.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, UUID> {

    Optional<AppUser> findByEmail(String email);
}
