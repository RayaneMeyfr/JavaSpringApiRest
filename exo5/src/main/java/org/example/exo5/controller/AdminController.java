package org.example.exo5.controller;

import org.example.exo5.dto.TodoReceiveDto;
import org.example.exo5.dto.TodoResponseDto;
import org.example.exo5.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/todo")
public class AdminController {

    private final TodoService todoService;

    public AdminController(TodoService todoService) {
        this.todoService = todoService;
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
