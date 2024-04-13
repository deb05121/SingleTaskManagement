package com.example.SingleTaskManagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "task")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String description;
    private Priority priority;
    @Column(name = "due_date")
    private Date dueDate;

}
