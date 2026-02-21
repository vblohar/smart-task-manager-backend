package com.smarttaskmanager.service;

import com.smarttaskmanager.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    TaskDTO createTask(TaskDTO dto);

    List<TaskDTO> getAllTasks();
}
