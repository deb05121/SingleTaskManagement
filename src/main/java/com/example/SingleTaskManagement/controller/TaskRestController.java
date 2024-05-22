package com.example.SingleTaskManagement.controller;

import com.example.SingleTaskManagement.dto.CreateTaskDto;
import com.example.SingleTaskManagement.model.Task;
import com.example.SingleTaskManagement.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TaskRestController {
    private final TaskService taskService;

    @GetMapping("/tasks")
    List<Task> getTasks() {
        log.info("Finding all tasks.");
        return taskService.getAllTask();
    }

    @PostMapping("/tasks")
    ResponseEntity<Task> addTask(@RequestBody @Valid CreateTaskDto createTaskDto) {
        log.info("Creating new task.{}", createTaskDto);
        Task task = createTaskDto.toTask();
        log.info("Adding new task.{}", task);

        return new ResponseEntity<>(taskService.addNewTask(task), HttpStatus.CREATED);
    }

    @DeleteMapping("/tasks/{id}")
    void deleteTaskById(@PathVariable long id) {
        log.info("Deleted a task with id {}", id);
        taskService.deleteTaskById(id);
    }

    @PutMapping("/tasks/{id}")
    ResponseEntity<Task> updateTask(@PathVariable long id, @RequestBody @Valid CreateTaskDto createTaskDto) {
        log.info("Updated the task with id {}", id);
        Task task = createTaskDto.toTask();
        taskService.updateTask(id, task);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
