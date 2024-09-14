package dev.tasker.api.controllers;


import dev.tasker.api.dto.request.TaskCreateDto;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface TaskController {
    // Les tâches sous forme de liste
    @GetMapping("/tasks")
    Map<Object, Object> taskList(
            @RequestParam(required = false) String keyword
    );

    @GetMapping("/tasks/paginate")
    Map<Object, Object> taskPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    );
    // Les tâches d'un utilisateur
    @GetMapping("/tasks/{id}")
    Map<Object, Object> taskByUser(@PathVariable Long id);


    // Les tâches d'un utilisateur
    @GetMapping("/tasks/{id}/details")
    Map<Object, Object> taskDetails(@PathVariable Long id);

    @PostMapping("/tasks")
    Map<Object, Object> taskSave(@Valid @RequestBody TaskCreateDto dto,
                                 BindingResult bindingResult);
}
