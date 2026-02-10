package com.example.Taskify.service.impl;

import com.example.Taskify.domain.CreateTaskRequest;
import com.example.Taskify.domain.entity.Task;
import com.example.Taskify.domain.entity.TaskStatus;
import com.example.Taskify.repository.TaskRepository;
import com.example.Taskify.service.TaskService;

import java.time.Instant;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreateTaskRequest request) {
        Instant now = Instant.now();
        Task task = new Task(
                null,
                request.title(),
                request.description(),
                request.dueDate(),
                TaskStatus.OPEN,
                request.priority(),
                now,
                now

        );
        return taskRepository.save(task);
    }
}
