package com.example.SingleTaskManagement.service;

import com.example.SingleTaskManagement.exception.TaskNotFoundException;
import com.example.SingleTaskManagement.model.Task;
import com.example.SingleTaskManagement.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAllTask() {

        return taskRepository.findAll();
    }


    public void deleteTaskById(long id) {
        taskRepository.deleteById(id);
    }

    public void updateTask(long id, Task task) {

        final var taskToUpdate = taskRepository.findById(id);
        for(Task task1: taskToUpdate){

            task1.setTitle(task.getTitle());
            task1.setDescription(task.getDescription());
            task1.setPriority(task.getPriority());
            task1.setDueDate(task.getDueDate());
            taskRepository.save(task1);
        }

    }

    public void addNewTask(Task task) {
        taskRepository.save(task);
    }

}
