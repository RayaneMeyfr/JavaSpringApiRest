package org.example.exo5.service;


import org.example.exo5.dto.TodoReceiveDto;
import org.example.exo5.dto.TodoResponseDto;
import org.example.exo5.entity.Todo;
import org.example.exo5.exception.NotFoundException;
import org.example.exo5.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<TodoResponseDto> get(){
        return todoRepository.findAll().stream().map(Todo::entityToDto).toList();
    }

    public TodoResponseDto get(int id){
        return todoRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public TodoResponseDto create(TodoReceiveDto todoReceiveDto){
        return todoRepository.save(todoReceiveDto.dtoToEntity()).entityToDto();
    }

    public TodoResponseDto update(int id, TodoReceiveDto todoReceiveDto) {
        Todo todoFind = todoRepository.findById(id).orElseThrow(NotFoundException::new);
        Todo todoGet = todoReceiveDto.dtoToEntity();
        todoFind.setTitle(todoGet.getTitle());
        todoFind.setDescription(todoGet.getDescription());
        todoFind.setDate(todoGet.getDate());
        return todoRepository.save(todoFind).entityToDto();
    }

    public TodoResponseDto changeStat(int id) {
        Todo todoFind = todoRepository.findById(id).orElseThrow(NotFoundException::new);
        todoFind.setIsValidate(!todoFind.getIsValidate());
        return todoRepository.save(todoFind).entityToDto();
    }

    public void delete(int id) {
        todoRepository.deleteById(id);
    }

    public List<TodoResponseDto> get(Boolean isValidate){
        return todoRepository.findByIsValidate(isValidate).stream().map(Todo::entityToDto).toList();
    }
}