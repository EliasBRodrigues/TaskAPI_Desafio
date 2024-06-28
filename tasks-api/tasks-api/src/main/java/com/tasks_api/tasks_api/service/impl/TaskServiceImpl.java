package com.tasks_api.tasks_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasks_api.tasks_api.exception.TaskNotFoundException;
import com.tasks_api.tasks_api.model.Task;
import com.tasks_api.tasks_api.repository.TaskRepository;
import com.tasks_api.tasks_api.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
    
    private TaskRepository taskRepository;
    
    @Autowired
    public TaskServiceImpl(TaskRepository theTaskRepository) {
        taskRepository = theTaskRepository;
    }
    
    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Integer id) {
        Optional<Task> result = taskRepository.findById(id);
        Task theTask = null;
        if(result.isPresent()){
            theTask = result.get();
        } else {
            throw new TaskNotFoundException("did not find task id " + id);
        }
        return theTask;
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(Integer id) {
        taskRepository.deleteById(id);
    }
    
}
