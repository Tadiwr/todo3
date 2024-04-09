package com.shangwa.todo3.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shangwa.todo3.model.Todo;


@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping
    public List<Todo> all() {
        return service.allTodos();  
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Optional<Todo> todo = service.getTodoById(id);

        return todo.map(ResponseEntity::ok).orElseGet(() -> 
            ResponseEntity.notFound().build()
        );
    }

    @PostMapping("/add")
    public ResponseEntity<String> addTodo(@RequestBody Todo todo) {
        String res = service.addTodo(todo);
        return ResponseEntity.ok(res);
    }
    
 
}
