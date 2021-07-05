package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardCodedService {
	
	private static List<Todo> todos = new ArrayList();
	private static int count_Id = 0;
	
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
}
