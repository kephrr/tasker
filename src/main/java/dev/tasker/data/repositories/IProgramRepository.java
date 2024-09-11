package dev.tasker.data.repositories;

import dev.tasker.data.entities.Person;
import dev.tasker.data.entities.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProgramRepository extends JpaRepository<Program, Long> {
    Optional<Program> findByIdAndIsActiveTrue(Long id);
}
