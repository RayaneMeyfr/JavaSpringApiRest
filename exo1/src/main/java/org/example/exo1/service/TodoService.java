package org.example.exo1.service;

import org.example.exo1.dto.TodoReceiveDto;
import org.example.exo1.dto.TodoResponseDto;
import org.example.exo1.exception.NotFindException;
import org.example.exo1.model.Todo;
import org.example.exo1.repository.TodoRepository;
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
        return todoRepository.findById(id).orElseThrow(NotFindException::new).entityToDto();
    }

    public TodoResponseDto create(TodoReceiveDto todoReceiveDto){
        return todoRepository.save(todoReceiveDto.dtoToEntity()).entityToDto();
    }

    public TodoResponseDto update(int id, TodoReceiveDto todoReceiveDto) {
        Todo todoFind = todoRepository.findById(id).orElseThrow(NotFindException::new);
        Todo todoGet = todoReceiveDto.dtoToEntityUpdate();
        todoFind.setTitle(todoGet.getTitle());
        todoFind.setDescription(todoGet.getDescription());
        todoFind.setDate(todoGet.getDate());
        todoFind.setIsValidate(todoGet.getIsValidate());
        return todoRepository.save(todoFind).entityToDto();
    }

    public void delete(int id) {
        todoRepository.deleteById(id);
    }

    public List<TodoResponseDto> get(Boolean isValidate){
        return todoRepository.findByIsValidate(isValidate).stream().map(Todo::entityToDto).toList();
    }
}
