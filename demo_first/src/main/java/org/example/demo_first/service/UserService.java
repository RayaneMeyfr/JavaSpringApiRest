package org.example.demo_first.service;

import org.example.demo_first.dto.UserReceiveDto;
import org.example.demo_first.dto.UserResponseDto;
import org.example.demo_first.entity.User;
import org.example.demo_first.exception.NotFoundException;
import org.example.demo_first.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto create(UserReceiveDto userReceiveDto) {
        return userRepository.save(userReceiveDto.dtoToEntity()).entityToDto();
    }

    public UserResponseDto get(int id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<UserResponseDto> get() {
        return userRepository.findAll().stream().map(User::entityToDto).toList();
    }

    public UserResponseDto update(int id, UserReceiveDto userReceiveDto) {
        User userFind = userRepository.findById(id).orElseThrow(NotFoundException::new);
        User userGet = userReceiveDto.dtoToEntity();
        userFind.setName(userGet.getName());
        userFind.setBirthday(userGet.getBirthday());
        userFind.setPassword(userGet.getPassword());
        return userRepository.save(userFind).entityToDto();
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
