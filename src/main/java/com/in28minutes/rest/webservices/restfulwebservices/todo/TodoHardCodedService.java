package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardCodedService {
	
	private static List<Todo> todos = new ArrayList();
	private static long count_Id = 0;
	
	static {
		todos.add(new Todo(++count_Id, "shiva", "Learn 11", new Date(), false));
		todos.add(new Todo(++count_Id, "shiva", "Learn 22", new Date(), false));
		todos.add(new Todo(++count_Id, "shiva", "Learn 33", new Date(), false));
		todos.add(new Todo(++count_Id, "shiva", "Learn 44", new Date(), false));
	}
	
	public List<Todo> findAll()
	{
		return todos;
	}
	
	public Todo save(Todo todo)
	{
		if(todo.getId() == -1 || todo.getId() == 0)
		{
			todo.setId(++count_Id);
			todos.add(todo);
		}
		else
		{
			deleteById(todo.getId());
			todos.add(todo);
		}
		
		return todo;
	}
	
	public Todo deleteById(long id)
	{
		Todo todo = findById(id);
		if(todo == null)
			return null;
		if(todos.remove(todo))
			return todo;
		
		return null;
	}
	
	public Todo findById(long id)
	{
		for(Todo t : todos)
		{
			if(t.getId() == id)
				return t;
		}
		
		return null;
	}
	
	
}
