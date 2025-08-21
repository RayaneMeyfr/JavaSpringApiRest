package org.example.exo5.controller;

import org.example.exo5.dto.TodoReceiveDto;
import org.example.exo5.dto.TodoResponseDto;
import org.example.exo5.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/co/todo")
public class UserController {

    private final TodoService todoService;

    public UserController(TodoService todoService) {
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

    @PutMapping("/change/{id}")
    public ResponseEntity<TodoResponseDto> change(@PathVariable int id) {
        return ResponseEntity.ok(todoService.changeStat(id));
    }
}