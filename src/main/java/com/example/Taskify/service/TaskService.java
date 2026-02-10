package com.example.Taskify.service;

import com.example.Taskify.domain.CreateTaskRequest;
import com.example.Taskify.domain.entity.Task;

public interface TaskService {
    Task createTask(CreateTaskRequest request);
}
