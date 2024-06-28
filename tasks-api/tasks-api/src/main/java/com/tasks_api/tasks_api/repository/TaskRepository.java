package com.tasks_api.tasks_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasks_api.tasks_api.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{
    
}
