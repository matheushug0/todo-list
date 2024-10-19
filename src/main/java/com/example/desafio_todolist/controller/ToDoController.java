package com.example.desafio_todolist.controller;

import com.example.desafio_todolist.entity.ToDo;
import com.example.desafio_todolist.service.ToDoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping
    List<ToDo> create(@RequestBody @Valid ToDo toDo){
        return toDoService.create(toDo);
    }

    @GetMapping
    List<ToDo> list(){
        return toDoService.list();
    }

    @PutMapping
    List<ToDo> update(@RequestBody ToDo toDo){
        return toDoService.update(toDo);
    }

    @DeleteMapping("{id}")
    List<ToDo> delete(@PathVariable Long id){
        return toDoService.delete(id);
    }
}
