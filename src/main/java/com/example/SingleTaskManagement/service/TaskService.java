package com.example.SingleTaskManagement.service;

import com.example.SingleTaskManagement.exception.TaskNotFoundException;
import com.example.SingleTaskManagement.model.Task;
import com.example.SingleTaskManagement.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public Task getTaskById(long id) {
        return taskRepository.getReferenceById(id);
    }

    public void deleteTaskById(long id) {
        taskRepository.deleteById(id);
    }

    public void updateTaskById(long id, Task task) {
        final var getTaskToUpdate = taskRepository.findById(id);
        if(getTaskToUpdate.isEmpty()){
            throw new TaskNotFoundException("No such task found");
        }
        final var taskToUpdate = getTaskToUpdate.get(0);
        taskToUpdate.setTitle(task.getTitle());
        taskToUpdate.setDescription(task.getDescription());
        taskToUpdate.setPriority(task.getPriority());
        taskToUpdate.setDueDate(task.getDueDate());
        taskRepository.save(taskToUpdate);
    }

    public void addTask(Task task){
        taskRepository.save(task);
    }

}
