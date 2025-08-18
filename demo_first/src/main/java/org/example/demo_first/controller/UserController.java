package org.example.demo_first.controller;

import org.example.demo_first.dto.UserReceiveDto;
import org.example.demo_first.dto.UserResponseDto;
import org.example.demo_first.entity.User;
import org.example.demo_first.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
//    @GetMapping
//    public User getUser() {
//        User user = new User();
//        user.setId(1);
//        user.setName("toto");
//        user.setBirthday(LocalDate.now());
//        user.setPassword("123456");
//        return user;
//    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll() {
        return ResponseEntity.ok(userService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> get(@PathVariable int id) {
        return ResponseEntity.ok(userService.get(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserReceiveDto userReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable int id, @RequestBody UserReceiveDto userReceiveDto) {
        return ResponseEntity.ok(userService.update(id, userReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        userService.delete(id);
        return ResponseEntity.ok(String.format("Deleted user with id %d", id));
    }
}
