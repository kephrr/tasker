package dev.tasker.data.entities;

import jakarta.persistence.Entity;
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
@Table(name="users")
public class Person extends AbstractEntity{
    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "user")
    List<Program> programs;
    @OneToMany(mappedBy = "user")
    List<Task> tasks;
}
