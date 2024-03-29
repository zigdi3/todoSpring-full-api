package com.zigdi3.todo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.zigdi3.todo.model.Todo;
import com.zigdi3.todo.repository.TodoRepository;


@SpringBootApplication
public class TodoApplication {
	
	@Autowired
	private TodoRepository todoRepository;
	
	@Bean
	public CommandLineRunner init () {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Todo todo = new Todo();
			 // System.out.println(Locale.getDefault());
				todo.setCreatedDate(LocalDateTime.now());
				todo.setDescription("Nova Nota!");
						
			
			}
		}; 
		}

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
		
	}

}
