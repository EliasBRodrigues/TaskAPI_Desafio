package com.tasks_api.tasks_api.com;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.tasks_api.tasks_api.exception.TaskNotFoundException;
import com.tasks_api.tasks_api.model.Task;
import com.tasks_api.tasks_api.repository.TaskRepository;
import com.tasks_api.tasks_api.service.impl.TaskServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TaskServiceTests {
    public static final Integer ID = 1;
    public static final String TASK_NOT_FOUND_EXCEPTION_MESSAGE = "Task not found with id: " + ID;
    public static final String TASK_NAME = "Study English";
    public static final String TASK_DESCRIPTION = "study hard";
    public static final Boolean TASK_COMPLETED = false;
    @Mock
    private TaskRepository repository;
    @InjectMocks
    private TaskServiceImpl service;
    private Task task;
    private Optional<Task> optionalTask;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startTask();
    }

    @Test
    void findByID() {
        when(repository.findById(Mockito.anyInt())).thenReturn(optionalTask);

        Task response = service.findById(ID);
        assertNotNull(response);
        assertEquals(Task.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(TASK_NAME, response.getTitle());
        assertEquals(TASK_DESCRIPTION, response.getDescription());
        assertEquals(TASK_COMPLETED, response.isCompleted());
    }

    @Test
    void findByIDExceptionTaskNotFound() {
        when(repository.findById(Mockito.anyInt())).thenThrow(new TaskNotFoundException(TASK_NOT_FOUND_EXCEPTION_MESSAGE));

        try {
            service.findById(ID);
        } catch (Exception ex) {
            assertEquals(TaskNotFoundException.class, ex.getClass());
            assertEquals(TASK_NOT_FOUND_EXCEPTION_MESSAGE, ex.getMessage());
        }
    }

    @Test
    void findAll(){
        when(repository.findAll()).thenReturn(List.of(task));
        List<Task> response = service.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Task.class, response.get(0).getClass());
        assertEquals(ID, response.get(0).getId());
        assertEquals(TASK_NAME, response.get(0).getTitle());
        assertEquals(TASK_DESCRIPTION, response.get(0).getDescription());
        assertEquals(TASK_COMPLETED, response.get(0).isCompleted());
    }


    @Test
    public void testDeleteById() {
        service.deleteById(ID);
        verify(repository, times(1)).deleteById(ID);
    }

    private void startTask() {
        task = new Task(ID, TASK_NAME, TASK_DESCRIPTION, TASK_COMPLETED);
        optionalTask = Optional.of(new Task(ID, TASK_NAME, TASK_DESCRIPTION, TASK_COMPLETED));
    }

}