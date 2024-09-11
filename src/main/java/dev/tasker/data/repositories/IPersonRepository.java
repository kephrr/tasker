package dev.tasker.data.repositories;

import dev.tasker.data.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByIdAndIsActiveTrue(Long id);
}
