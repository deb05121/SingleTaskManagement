package com.example.SingleTaskManagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity(name = "task")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Task {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Column(name = "due_date")
    private Date dueDate;

    @Override
    public String toString() {
        return  dueDate + "";
    }
}
