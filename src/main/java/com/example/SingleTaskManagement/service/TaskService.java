package com.example.SingleTaskManagement.service;

import com.example.SingleTaskManagement.model.Task;
import com.example.SingleTaskManagement.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAllTask() {

        return taskRepository.findAll();
    }


    public void deleteTaskById(long id) {
        taskRepository.deleteById(id);
    }

    public void updateTask(long id, Task taskOfUser) {

        final var taskToUpdate = taskRepository.findById(id);
        taskToUpdate.ifPresentOrElse(
                (task1) -> {
                    task1.setTitle(taskOfUser.getTitle());
                    task1.setDescription(taskOfUser.getDescription());
                    task1.setPriority(taskOfUser.getPriority());
                    task1.setDueDate(taskOfUser.getDueDate());
                    taskRepository.save(taskToUpdate.orElseThrow());
                },
                () -> log.error("No value")
        );

    }

    public Task addNewTask(Task task) {
        taskRepository.save(task);
        return task;
    }
}
