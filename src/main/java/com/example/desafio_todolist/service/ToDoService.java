package com.example.desafio_todolist.service;

import com.example.desafio_todolist.entity.ToDo;
import com.example.desafio_todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.ToDoubleBiFunction;

@Service
public class ToDoService {
    private ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> create(ToDo todo) {
        toDoRepository.save(todo);
        return list();
    }

    public List<ToDo> list() {
        Sort sort = Sort.by("priority").descending().and(Sort.by("done").descending()).and(Sort.by("title").ascending());
        return toDoRepository.findAll(sort);
    }

    public List<ToDo> update(ToDo toDo) {
        toDoRepository.save(toDo);
        return list();
    }

    public List<ToDo> delete(Long id) {
        toDoRepository.deleteById(id);
        return list();
    }

}
