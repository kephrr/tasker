package dev.tasker.services.Impl;

import dev.tasker.data.entities.Program;
import dev.tasker.data.repositories.IProgramRepository;
import dev.tasker.services.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {
    private final IProgramRepository programRepository;
    @Override
    public Program save(Program data) {
        return programRepository.save(data);
    }

    @Override
    public Page<Program> findAll(Pageable pageable) {
        return programRepository.findAll(pageable);
    }

    @Override
    public List<Program> findAll() {
        return programRepository.findAll();
    }

    @Override
    public Optional<Program> show(Long dataID) {
        return programRepository.findByIdAndIsActiveTrue(dataID);
    }
}
