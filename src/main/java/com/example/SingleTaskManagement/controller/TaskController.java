package com.example.SingleTaskManagement.controller;

import com.example.SingleTaskManagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/tasks/view")
    public String viewTasks(Model model) {
        log.info("Listing all tasks on ViewTasks.html");
        model.addAttribute("tasks", taskService.getAllTask());
        return "ViewTasks";
    }
}
