package com.example.SingleTaskManagement.repository;

import com.example.SingleTaskManagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findAll();

   
  

    List<Task> findById(long id);


}
