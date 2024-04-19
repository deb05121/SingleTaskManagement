package com.example.SingleTaskManagement.controller;

import com.example.SingleTaskManagement.model.Task;
import com.example.SingleTaskManagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    void addTask(@RequestBody Task task) {
        log.info("Adding new task.{}", task);
        taskService.addNewTask(task);
    }

    @DeleteMapping("/tasks/{id}")
    void deleteTaskById(@PathVariable long id) {
        log.info("Deleted a task with id {}", id);
        taskService.deleteTaskById(id);
    }

    @PutMapping("/tasks/{id}")
    void updateTask(@PathVariable long id, @RequestBody Task task) {
        log.info("Updated the task with id {}", id);
        taskService.updateTask(id, task);
    }
}
