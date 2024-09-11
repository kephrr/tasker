package dev.tasker.api.controllers.Impl;

import dev.tasker.api.controllers.TaskController;
import dev.tasker.api.dto.request.TaskCreateDto;
import dev.tasker.api.dto.response.TaskDto;
import dev.tasker.api.dto.response.rest.RestResponseDto;
import dev.tasker.data.entities.Person;
import dev.tasker.data.entities.Task;
import dev.tasker.services.PersonService;
import dev.tasker.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Conditional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class TaskControllerImpl implements TaskController {
    private final TaskService taskService;
    private final PersonService personService;
    @Override
    public Map<Object, Object> taskList() {
        List<TaskDto> results = taskService.findAll().stream()
                .map(TaskDto::toDto).toList();
        return  RestResponseDto.response(
                results,
                HttpStatus.OK
        );
    }


    @Override
    public Map<Object, Object> taskPage(int page, int size) {
        Page<TaskDto> results = taskService.findAll(PageRequest.of(page, size))
                .map(TaskDto::toDto);
        return  RestResponseDto.response(
                results.getContent(),
                new int[results.getTotalPages()],
                page,
                results.getTotalElements(),
                results.getTotalPages(),
                HttpStatus.OK
        );
    }

    @Override
    public Map<Object, Object> taskByUser(Long id) {
        Person user = personService.show(id).orElse(null);
        List<TaskDto> results = taskService.findAllByIdUser(user)
                .stream().map(TaskDto::toDto).toList();
        return  RestResponseDto.response(
                results,
                HttpStatus.OK
        );
    }

    @Override
    public Map<Object, Object> taskDetails(Long id) {
        Task data = taskService.show(id).orElse(null);
        TaskDto result = TaskDto.toDto(data);
        return  RestResponseDto.response(
                result,
                HttpStatus.OK
        );
    }

    @Override
    public Map<Object, Object> taskSave(TaskCreateDto dto, BindingResult bindingResult) {
        Map<Object, Object> response;
        if (bindingResult.hasErrors()){
            // Envoyer les erreurs en reponse
            Map<String, String> errors =new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
            response= RestResponseDto.response(errors, HttpStatus.NOT_ACCEPTABLE);
        }else{
            try {
                // Creer le signalement
                Task task  = TaskCreateDto.toEntity(dto);
                response= RestResponseDto.response(dto,HttpStatus.CREATED);
            }catch (Exception e) {
                // Conflit de DTO
                response= RestResponseDto.response(dto,HttpStatus.NOT_ACCEPTABLE);
                System.out.println(e.getMessage());
            }
        }
        return RestResponseDto.response(
                response,
                HttpStatus.OK
        );
    }
}
