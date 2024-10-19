package com.example.desafio_todolist.repository;

import com.example.desafio_todolist.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
