package dev.tasker.services.Impl;

import dev.tasker.data.entities.Person;
import dev.tasker.data.entities.Task;
import dev.tasker.data.repositories.ITaskRepository;
import dev.tasker.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final ITaskRepository taskRepository;
    @Override
    public Task save(Task data) {
        return taskRepository.save(data);
    }

    @Override
    public Page<Task> findAll(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> show(Long dataID) {
        return taskRepository.findById(dataID);
    }

    @Override
    public List<Task> findAllByIdUser(Person user) {
        return taskRepository.findAllByUser(user);
    }
}
