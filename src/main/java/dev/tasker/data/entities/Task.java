package dev.tasker.data.entities;


import dev.tasker.data.enums.EtatTask;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="tasks")
public class Task extends AbstractEntity{
    @Column(unique = true, nullable = false)
    private String title;
    @Column(length = 10000)
    private String description;
    @Enumerated(value = EnumType.STRING)
    private EtatTask etat;
    @ManyToOne
    Program program;
    @ManyToOne
    Person user;
}
