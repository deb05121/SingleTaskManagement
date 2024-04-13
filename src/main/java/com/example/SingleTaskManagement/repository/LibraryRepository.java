package com.example.SingleTaskManagement.repository;

import com.example.SingleTaskManagement.model.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibraryRepository extends JpaRepository<BorrowedBook, Long> {
    List<BorrowedBook> findAll();
    List<BorrowedBook> findId();
    List<BorrowedBook> findTitle();

}
