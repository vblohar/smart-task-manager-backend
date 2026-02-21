package com.smarttaskmanager.mapper;

import com.smarttaskmanager.dto.TaskDTO;
import com.smarttaskmanager.entity.Task;
import com.smarttaskmanager.entity.TaskStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TaskMapperTest {

    @InjectMocks
    private TaskMapper mapper;

    @Test
    void shouldMapDtoToEntityCorrectly() {
        UUID sampleId = UUID.randomUUID();

        TaskDTO dto = new TaskDTO();
        dto.setId(sampleId);
        dto.setTitle("Finish Project");
        dto.setDescription("Complete the Spring Boot task manager");
        dto.setStatus("PENDING");
        LocalDateTime before = LocalDateTime.now().minusSeconds(1);

        Task entity = mapper.toEntity(dto);
        LocalDateTime after = LocalDateTime.now().plusSeconds(1);

        assertNotNull(entity);
        assertEquals(sampleId, entity.getId());
        assertEquals("Finish Project", entity.getTitle());
        assertEquals("Complete the Spring Boot task manager", entity.getDescription());
        assertEquals("PENDING", entity.getStatus().name());
        assertTrue(entity.getCreatedAt().isAfter(before) && entity.getCreatedAt().isBefore(after));

    }

    @Test
    void shouldMapEntityToDTOCorrectly() {
        UUID sampleId = UUID.randomUUID();
        TaskStatus status = TaskStatus.valueOf("COMPLETED");

        Task entity = new Task();
        entity.setId(sampleId);
        entity.setTitle("Finish Project");
        entity.setDescription("Complete the Spring Boot task manager");
        entity.setStatus(status);

        TaskDTO dto = mapper.toDTO(entity);

        assertNotNull(dto);
        assertEquals(sampleId, dto.getId());
        assertEquals("Finish Project", dto.getTitle());
        assertEquals("Complete the Spring Boot task manager", dto.getDescription());
        assertEquals("COMPLETED", dto.getStatus());

    }
}