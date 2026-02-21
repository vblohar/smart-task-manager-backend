package com.smarttaskmanager.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class TaskDTO {
    private UUID id;

    @NotBlank
    private String title;

    private String description;

    private String status;
}
