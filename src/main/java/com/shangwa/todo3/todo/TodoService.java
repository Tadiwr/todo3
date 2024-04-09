package com.shangwa.todo3.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangwa.todo3.model.Todo;

@Service
public class TodoService {
    
    @Autowired
    private TodoRepostitory todoRepo;

    public List<Todo> allTodos() {
        // Todo td = new Todo("Brush your teeth");
        // return List.of(td);

        return (List<Todo>) todoRepo.findAll();
    }


}
