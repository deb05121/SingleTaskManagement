package com.example.SingleTaskManagement.controller;

import com.example.SingleTaskManagement.model.Task;
import com.example.SingleTaskManagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TaskRestController {
    private final TaskService taskService;


    @GetMapping("/tasks")
    List<Task> getTasks() {
        log.info("Finding all tasks.");
        return null;
    }


}
