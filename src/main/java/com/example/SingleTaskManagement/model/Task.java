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
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    //to be compatible with Enum of MySQL database
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Column(name = "due_date")
    private Date dueDate;


}
