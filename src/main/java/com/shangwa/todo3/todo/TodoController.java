package com.shangwa.todo3.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService service;

    @Autowired
    TodoController(TodoService todoService) {
        this.service = todoService;
    }

    @GetMapping
    public List<Todo> all() {
        return service.allTodos();  
    }
 
 
}
