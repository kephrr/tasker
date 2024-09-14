package dev.tasker.data.repositories;

import dev.tasker.data.entities.Person;
import dev.tasker.data.entities.Task;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ITaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByIdAndIsActiveTrue(Long id);

    @Query("SELECT DISTINCT t FROM Task t "+
            "WHERE t.isActive = true "+
            "AND :user IS NULL OR t.user=:user")
    List<Task> findAllByUser(@Param("user") Person user);

    @Query("SELECT DISTINCT t FROM Task t "+
            "WHERE t.isActive = true "+
            "AND :keyword IS NULL OR t.title LIKE %:keyword% "+
            "OR :keyword IS NULL OR t.description LIKE %:keyword% ")
    List<Task> findAllByFilter(@Param("keyword") String keyword);
}
