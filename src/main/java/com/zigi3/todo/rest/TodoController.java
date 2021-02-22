package com.zigi3.todo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.zigi3.todo.model.Todo;
import com.zigi3.todo.repository.TodoRepository;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
	
	@Autowired
	private TodoRepository repository;
	
	@PostMapping
	public Todo save (@RequestBody Todo todo) {
	return repository.save(todo);
	
	}
	
	
	@GetMapping("{id}")
	public  Todo getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
	}
	
}
