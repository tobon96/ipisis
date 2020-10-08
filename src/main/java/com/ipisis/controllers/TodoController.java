package com.ipisis.controllers;

import com.ipisis.models.Todo;
import com.ipisis.repositories.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping("/test")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Todo> createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Todo> getTodos() {
        return todoRepository.findAll().log();
    }
}
