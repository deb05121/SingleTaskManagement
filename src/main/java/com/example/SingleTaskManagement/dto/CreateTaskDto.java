package com.example.SingleTaskManagement.dto;

import com.example.SingleTaskManagement.model.Priority;
import com.example.SingleTaskManagement.model.Task;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.sql.Date;

@Data
public class CreateTaskDto {

    @NotNull(message = "Title is required")
    @NotEmpty(message = "Title can't be empty")
    @Pattern(regexp = "[ABC]\\/2024", message = "Title must start with Capital letter: A, B or C")
    @Size(max = 6, message = "Max 6 characters must be")
    private String title;

    @NotNull(message = "Description is required")
    @NotEmpty(message = "Description can't be empty")
    @Size(max = 45, message = "Max 45 characters must be")
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(name = "due_date")
    @FutureOrPresent
    private Date dueDate;

    public Task toTask() {
        return Task
                .builder()
                .title(title)
                .description(description)
                .priority(priority)
                .dueDate(dueDate)
                .build();
    }

}
