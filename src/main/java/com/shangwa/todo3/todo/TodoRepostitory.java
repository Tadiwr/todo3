package com.shangwa.todo3.todo;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepostitory extends CrudRepository<Todo, Long>{
    
}
