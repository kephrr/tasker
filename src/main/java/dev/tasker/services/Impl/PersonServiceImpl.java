package dev.tasker.services.Impl;

import dev.tasker.data.entities.Person;
import dev.tasker.data.repositories.IPersonRepository;
import dev.tasker.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final IPersonRepository personRepository;
    @Override
    public Person save(Person data) {
        return personRepository.save(data);
    }

    @Override
    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> show(Long dataID) {
        return personRepository.findByIdAndIsActiveTrue(dataID);
    }
}
