package dev.tasker.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="programs")
public class Program extends AbstractEntity{
    private String title;
    @OneToMany(mappedBy = "program")
    List<Task> tasks;
    @ManyToOne
    Person user;
}
