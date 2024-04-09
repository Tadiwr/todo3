package com.shangwa.todo3.todo;

import org.springframework.data.repository.CrudRepository;

import com.shangwa.todo3.model.Todo;

public interface TodoRepostitory extends CrudRepository<Todo, Long>{
    
}
