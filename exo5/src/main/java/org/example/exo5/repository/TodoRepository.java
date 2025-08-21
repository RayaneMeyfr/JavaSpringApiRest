package org.example.exo5.repository;

import org.example.exo5.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Integer> {
    List<Todo> findByIsValidate(boolean isValidate);
}