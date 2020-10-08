package com.ipisis.repositories;

import com.ipisis.models.Todo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TodoRepository extends ReactiveCrudRepository<Todo, Long> {
}
