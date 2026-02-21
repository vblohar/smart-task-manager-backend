package com.smarttaskmanager.service;

import com.smarttaskmanager.dto.TaskDTO;
import com.smarttaskmanager.entity.Task;
import com.smarttaskmanager.mapper.TaskMapper;
import com.smarttaskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;
    private final TaskMapper mapper;

    @Override
    public TaskDTO createTask(TaskDTO dto) {
       Task task = mapper.toEntity(dto);
       return mapper.toDTO(repository.save(task));

    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();

    }
}
