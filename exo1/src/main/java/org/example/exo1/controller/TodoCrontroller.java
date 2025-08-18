package org.example.exo1.controller;

import org.example.exo1.dto.TodoReceiveDto;
import org.example.exo1.dto.TodoResponseDto;
import org.example.exo1.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class TodoCrontroller {
    
    private final TodoService todoService;

    public TodoCrontroller(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> findAll() {
        return ResponseEntity.ok(todoService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> get(@PathVariable int id) {
        return ResponseEntity.ok(todoService.get(id));
    }

    @GetMapping("/true")
    public ResponseEntity<List<TodoResponseDto>> getValidate() {
        return ResponseEntity.ok(todoService.get(true));
    }

    @GetMapping("/false")
    public ResponseEntity<List<TodoResponseDto>> getNoValidate() {
        return ResponseEntity.ok(todoService.get(false));
    }

    @PostMapping
    public ResponseEntity<TodoResponseDto> create(@RequestBody TodoReceiveDto todoReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(todoReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDto> update(@PathVariable int id, @RequestBody TodoReceiveDto todoReceiveDto) {
        return ResponseEntity.ok(todoService.update(id, todoReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        todoService.delete(id);
        return ResponseEntity.ok(String.format("Deleted user with id %d", id));
    }

}
