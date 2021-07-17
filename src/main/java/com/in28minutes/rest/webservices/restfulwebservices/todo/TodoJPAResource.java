package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoJPAResource {
	
	@Autowired
	private TodoHardCodedService todoService;
	
	@Autowired
	private TodoJPARepository todoJPARepository;
	
	@GetMapping("/jpa/users/{userName}/todos")
	public List<Todo> getAllTodos(@PathVariable String userName)
	{
		return todoJPARepository.findByUsername(userName);
	}
	
	@GetMapping("/jpa/users/{userName}/todos/{id}")
	public Todo getATodo(@PathVariable String userName, @PathVariable long id)
	{
		return todoJPARepository.findById(id).isPresent() ? todoJPARepository.findById(id).get() : null;
	}
	
	@PostMapping("/jpa/users/{userName}/todos")
	public ResponseEntity<Void> createTodo(@PathVariable String userName, @RequestBody Todo todo)
	{
		todo.setUserName(userName);
		Todo createdTodo = todoJPARepository.save(todo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/jpa/users/{userName}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String userName, @PathVariable long id, @RequestBody Todo todo)
	{
		todo.setUserName(userName);
		Date d = todo.getTargetDate();
		todo.setTargetDate(new Date(d.getTime() + (1000 * 60 * 60 * 5)));
		
		Todo updatedTodo = todoJPARepository.save(todo);
		return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
	}
	
	@DeleteMapping("/jpa/users/{userName}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String userName, @PathVariable long id)
	{
		todoJPARepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
