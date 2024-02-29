package todo.api.controller;

import todo.api.entity.TodoEntity;
import todo.api.service.TodoService;

import java.util.List;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import todo.api.dto.TodoDTO;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    List<TodoEntity> create(@RequestBody TodoDTO todoDTO) {
        return todoService.create(todoDTO);
    }

    @GetMapping
    List<TodoEntity> list() {
        return todoService.list();
    }

    @PutMapping
    List<TodoEntity> update(@RequestBody TodoDTO todoDTO) {
        return todoService.update(todoDTO);
    }

    @DeleteMapping("{id}")
    List<TodoEntity> delete(@PathVariable("id") UUID id) {
        return todoService.delete(id);
    }

}
