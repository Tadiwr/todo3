package com.shangwa.todo3.todo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.shangwa.todo3.model.Todo;

public interface TodoRepostitory extends CrudRepository<Todo, Long>{
    
    @SuppressWarnings("null")
    public Optional<Todo> findById(Long id);
}
