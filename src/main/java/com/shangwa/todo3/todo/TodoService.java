package com.shangwa.todo3.todo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    
    @Autowired
    private TodoRepostitory todoRepo;

    public List<Todo> allTodos(boolean shouldSortDec) {

        List<Todo> models = (List<Todo>) todoRepo.findAll();

        if (shouldSortDec) {
            models = models.stream()
                .sorted((model1, model2) -> Long.compare(model2.getId(), model1.getId()))
                .collect(Collectors.toList());
        }

        return models;
        
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepo.findById(id);
    }

    public Todo addTodo(Todo t) {
        Todo todo = this.todoRepo.save(t);
        return todo;
    }

    public void deleteTodoWithId(Long id) {
        this.todoRepo.deleteById(id);
    }

    public void deleteAllTodos() {
        this.todoRepo.deleteAll();
    }

    public Todo updateTodo(Todo todo) {
        this.todoRepo.save(todo);
        return todo;
    }

    public void completeTodo(Long id) {
        Todo thisTodo = this.todoRepo.findById(id)
        .get();

        thisTodo.setCompleted(true);
        this.todoRepo.save(thisTodo);
    }

    public void unTickTodo(Long id) {
        Todo thisTodo = this.todoRepo.findById(id)
        .get();

        thisTodo.setCompleted(false);
        this.todoRepo.save(thisTodo);
    }

    public Optional<Todo> getLastAddedTodo() {

        List<Todo> models = this.allTodos(true);

        if (models.size() > 0) {
            return Optional.ofNullable(models.get(0));
        }

        return null;
    }

    public Optional<Todo> getFirstAddedTodo() {

        List<Todo> models = this.allTodos(false);

        if (models.size() > 0) {
            return Optional.ofNullable(models.get(0));
        }

        return null;
    }
}


