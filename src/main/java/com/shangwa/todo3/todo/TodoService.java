package com.shangwa.todo3.todo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    
    public List<Todo> allTodos() {
        Todo td = new Todo("Brush your teeth");
        return List.of(td);
    }
}
