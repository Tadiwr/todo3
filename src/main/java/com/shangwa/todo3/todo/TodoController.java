package com.shangwa.todo3.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping
    public List<Todo> all(@RequestParam(name="ztoa", required=false) boolean ztoa ) {
        return service.allTodos(ztoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Optional<Todo> todo = service.getTodoById(id);

        return todo.map(ResponseEntity::ok).orElseGet(() -> 
            ResponseEntity.notFound().build()
        );
    }

    @PostMapping("/add")
    public void addTodo(@RequestBody Todo todo) {
        service.addTodo(todo);
    }

    @DeleteMapping("/delete")
    public void deleteTodoById(@RequestBody DeleteByIdReqBody body) {
        service.deleteTodoWithId(body.todoId);
    }

    @DeleteMapping("/delete/all")
    public void deleteAllTodos() {
        service.deleteAllTodos();
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateTodoById(@RequestBody Todo todo) {
        this.service.updateTodo(todo);
        return ResponseEntity.ok("todo was updated");
    }

    @PostMapping("/complete")
    public void completeTodo(@RequestBody CompleteTodoReqBody body) {
        service.completeTodo(body.todoId);
    }
    
    @PostMapping("/untick")
    public void untickTodo(@RequestBody CompleteTodoReqBody body) {
        service.unTickTodo(body.todoId);
    }

}

class DeleteByIdReqBody {
    public Long todoId;
}

class CompleteTodoReqBody {
    public Long todoId;
}