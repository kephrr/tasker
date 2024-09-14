package dev.tasker.api.dto.response;

import dev.tasker.data.entities.Task;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskCardDto {
    private Long id;
    private String title;
    private String description;
    private String etat;
    public static TaskCardDto toDto(Task task) {
        return TaskCardDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .etat(task.getEtat().toString())
                .build();
    }
}
