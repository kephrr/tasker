package dev.tasker.data.fixtures;

import dev.tasker.data.entities.Person;
import dev.tasker.data.repositories.IPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
//@Component
@Order(0)
public class PersonFixtures implements CommandLineRunner {
    private final IPersonRepository personRepository;
    @Override
    public void run(String... args) throws Exception {
        String[] noms = {"Kephren", "account","profile"};
        String[] prenoms = {"NZE","Admin","Customer"};
        for (int i = 0; i < 3; i++) {
            personRepository.save(Person.builder()
                            .nom(noms[i])
                            .prenom(prenoms[i])
                    .build());
        }
    }
}
