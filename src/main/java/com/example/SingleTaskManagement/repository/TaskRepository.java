package com.example.SingleTaskManagement.repository;

import com.example.SingleTaskManagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAll();

    Optional<Task> findById(long id);


}
