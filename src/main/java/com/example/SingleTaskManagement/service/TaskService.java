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

    public void updateTask(long id, Task task) {
        if (validator(task.getTitle(), task.getDescription(), task.getDueDate().toString())) {

            final var taskToUpdate = taskRepository.findById(id);
            for (Task task1 : taskToUpdate) {
                task1.setTitle(task.getTitle());
                task1.setDescription(task.getDescription());
                task1.setPriority(task.getPriority());
                task1.setDueDate(task.getDueDate());
                taskRepository.save(task1);
            }
        } else {
            log.error("These are invalid data.");
        }

    }

    public void addNewTask(Task task) {

        if (validator(task.getTitle(), task.getDescription(), task.getDueDate().toString())) {

            taskRepository.save(task);
        } else {
            log.error("This isn't valid task object.");
        }
    }

    private boolean validator(String title, String description, String taskDate) {

        return (titleValidator(title) && descriptionValidator(description) && javaDateValidator(taskDate));
    }

    boolean titleValidator(String title) {

        return title.matches("[ABC]/2024");
    }

    boolean descriptionValidator(String description) {

        return description.length() <= 45;
    }

    boolean javaDateValidator(String taskDate) {

        return taskDate.matches("2024-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])");
    }
}
