package com.tasks_api.tasks_api.controller;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import jakarta.validation.Valid;

import com.tasks_api.tasks_api.exception.TaskNotFoundException;
import com.tasks_api.tasks_api.model.Task;
import com.tasks_api.tasks_api.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskApplicationController {

    private TaskService taskService;
    private static final String EXCEPTION_MESSAGE = "Task not found with id: ";

    @Autowired
    public TaskApplicationController(TaskService theTaskService) {
        taskService = theTaskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> listTasks() {
        List<Task> taskList = taskService.findAll();
        if(taskList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(taskList);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> showTask(@PathVariable Integer id) {
        Task theTask = taskService.findById(id);
        if (theTask == null) {
            throw new TaskNotFoundException(EXCEPTION_MESSAGE + id);
        }
        return ResponseEntity.ok(theTask);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> addTask(@Valid @RequestBody Task theTask) {
        theTask.setId(0);
        Task savedTask = taskService.save(theTask);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedTask.getId())
                .toUri();
        return ResponseEntity.created(location).body(theTask);
    }

    @PutMapping("/tasks")
    public ResponseEntity<Task> updateTask(@Valid @RequestBody Task theTask) {
        Task updatedTask = taskService.save(theTask);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Integer id) {
        Task tempTask = taskService.findById(id);
        if (tempTask == null) {
            throw new TaskNotFoundException(EXCEPTION_MESSAGE + id);
        }
        taskService.deleteById(id);
        return ResponseEntity.ok("task id deleted: " + id);
    }
}
