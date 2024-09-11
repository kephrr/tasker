package dev.tasker.api.dto.request;
import dev.tasker.data.entities.Task;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskCreateDto {
    @NotBlank(message = "Un titre est obligatoire")
    private String title;
    private String description;

    public static Task toEntity(TaskCreateDto dto){
        return Task.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .build();
    }
}
