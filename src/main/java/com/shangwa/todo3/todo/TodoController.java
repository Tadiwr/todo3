package com.shangwa.todo3.todo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @GetMapping("/todos")
    public List<Todo> allStudents() {
        Todo std = new Todo(1, "Learn Spring Boot");
        return List.of(std);
    }
 
}
