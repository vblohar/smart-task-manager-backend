package com.smarttaskmanager.mapper;

import com.smarttaskmanager.dto.TaskDTO;
import com.smarttaskmanager.entity.Task;
import com.smarttaskmanager.entity.TaskStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskMapper {
    public Task toEntity(TaskDTO dto) {
        return Task.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(TaskStatus.valueOf(dto.getStatus()))
                .createdAt(LocalDateTime.now())
                .build();
    }

    public TaskDTO toDTO(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus().name());

        return dto;
    }
}
