package com.tasks_api.tasks_api.service;

import java.util.List;

import com.tasks_api.tasks_api.model.Task;

public interface TaskService {
    List<Task> findAll();
    Task findById(Integer id);
    Task save(Task task);
    void deleteById(Integer id);
}