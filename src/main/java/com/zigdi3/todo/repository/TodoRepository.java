package com.zigdi3.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zigdi3.todo.model.Todo;


public interface TodoRepository  extends JpaRepository<Todo, Long>{
}

