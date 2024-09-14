package dev.tasker.services;

import dev.tasker.data.entities.Person;
import dev.tasker.data.entities.Task;

import java.util.List;

public interface TaskService extends IService<Task, Long> {
    List<Task> findAllByIdUser(Person user);
    List<Task> findAllByFilter(String keyword);

}
